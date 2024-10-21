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
import net.minecraft.world.World;

public class Vape extends Item {



    public Vape(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(stack);
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
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 600, 0));

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,2.0F,0.2F);

            if (world.isClient) {
                for (int i = 0; i < 100; i++) {
                    double offsetX = (world.random.nextFloat() - 0.5) * 2;
                    double offsetY = world.random.nextFloat() * 2;
                    double offsetZ = (world.random.nextFloat() - 0.5) * 2;
                    world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, player.getX() + offsetX, player.getY() + offsetZ, player.getZ() + offsetZ, 0, 0.1, 0);
                }
            }

            return stack;
        }

        return stack;
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
