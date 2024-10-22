package net.mpunans.diddypack.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.*;

public class Vape extends Item {

    private static final int BASE_DELAY_TICKS = 300;
    private static final int EFFECT_DURATION_BASE = 200;

    private static final Map<UUID, Integer> effectDelays = new HashMap<>();
    private static final Map<UUID, Integer> useCount = new HashMap<>();

    public Vape(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS, 1.0F, 2.0F);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        UUID playerUUID = user.getUuid();
        stack.damage(1, user, LivingEntity.getSlotForHand(user.getActiveHand()));
        if (effectDelays.containsKey(playerUUID)) {
            effectDelays.put(playerUUID, BASE_DELAY_TICKS);
            useCount.put(playerUUID, useCount.get(playerUUID) + 1);
        } else {
            effectDelays.put(playerUUID, BASE_DELAY_TICKS);
            useCount.put(playerUUID, 1);
        }
        if (user.isSneaking() && user instanceof PlayerEntity player) {
            spawnLetterParticles(world, player);
        } else {
            for (int i = 0; i < 200; i++) {
                double offsetX = (world.random.nextFloat()) - 0.75;
                double offsetY = world.random.nextFloat();
                double offsetZ = (world.random.nextFloat()) - 0.75;
                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        user.getX() + offsetX, user.getY() + 1 + offsetY, user.getZ() + offsetZ,
                        0.01, 0.000001, 0.01);
                world.addParticle(ParticleTypes.LARGE_SMOKE,
                        user.getX() + offsetX, user.getY() + 1 + offsetY, user.getZ() + offsetZ,
                        0.01, 0.000001, 0.01);
            }
            return stack;
        }

        return stack;
    }

    private void spawnLetterParticles(World world, PlayerEntity player) {
        Vec3d playerPos = player.getEyePos();
        double spacing = 1.1;

        double[][] N = {
                {0, 0}, {0, 1}, {0, 2}, {0.5, 0.5}, {1, 0}, {1, 1}, {1, 2}
        };
        double[][] I = {
                {0, 0}, {0, 1}, {0, 2}
        };
        double[][] G = {
                {0, 1}, {0, 2}, {0.5, 2}, {1, 2}, {1, 1}, {1, 0.5}, {0.5, 0.5}
        };
        double[][] E = {
                {0, 0}, {0, 1}, {0, 2}, {0.5, 2}, {0.5, 1}, {0.5, 0}
        };
        double[][] R = {
                {0, 0}, {0, 1}, {0, 2}, {0.5, 2}, {1, 1.5}, {0.5, 1}, {1, 0}
        };

        spawnLetter(world, playerPos, N, 0, spacing);
        spawnLetter(world, playerPos, I, 1, spacing);
        spawnLetter(world, playerPos, G, 2, spacing);
        spawnLetter(world, playerPos, G, 3, spacing);
        spawnLetter(world, playerPos, E, 4, spacing);
        spawnLetter(world, playerPos, R, 5, spacing);
    }

    private void spawnLetter(World world, Vec3d playerPos, double[][] letterCoords, int letterIndex, double spacing) {
        double xOffset = letterIndex * spacing * 2;
        int particleDensity = 10;

        for (double[] coord : letterCoords) {
            for (int i = 0; i < particleDensity; i++) {
                double x = playerPos.x + coord[0] + xOffset + (world.random.nextDouble() - 0.5) * 0.1;
                double y = playerPos.y + coord[1] + (world.random.nextDouble() - 0.5) * 0.1;
                double z = playerPos.z + (world.random.nextDouble() - 0.5) * 0.1;

                world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, 0, 0, 0);
            }
        }
    }


    public static void tick(World world) {
        if (!world.isClient) {
            for (UUID playerUUID : new HashSet<>(effectDelays.keySet())) {
                int delay = effectDelays.get(playerUUID);

                if (delay > 0) {
                    effectDelays.put(playerUUID, delay - 1);
                } else {
                    PlayerEntity player = world.getServer().getPlayerManager().getPlayer(playerUUID);
                    if (player != null) {
                        int multiplier = useCount.get(playerUUID);
                        applyEffects(player, multiplier);
                    }

                    effectDelays.remove(playerUUID);
                    useCount.remove(playerUUID);
                }
            }
        }
    }

    private static void applyEffects(PlayerEntity player, int multiplier) {
        if (multiplier >= 3) {
            int effectDuration = EFFECT_DURATION_BASE * (multiplier - 2);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, effectDuration, 2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, effectDuration, 0));
        }

    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 32;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.PASS;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
