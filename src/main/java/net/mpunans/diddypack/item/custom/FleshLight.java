package net.mpunans.diddypack.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mpunans.diddypack.item.ModItems;

public class FleshLight extends Item {

    private static final int COOLDOWN_TICKS = 1200;

    public FleshLight(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && !user.getItemCooldownManager().isCoolingDown(this)) {
            ItemStack stack = new ItemStack(ModItems.CUM);
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_DONKEY_HURT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            user.dropStack(stack);
            user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            stack.damage(1, user, LivingEntity.getSlotForHand(user.getActiveHand()));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_DONKEY_ANGRY, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        return super.use(world, user, hand);
    }
}
