package net.mpunans.diddypack.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class DiddyFondler extends Item {

    public DiddyFondler(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity.isBaby()) {
            World world = user.getWorld();
            stack.decrement(1);

            int emerladsToDrop = 1;

            for (int i = 0; i < emerladsToDrop; i++) {
                entity.dropStack(new ItemStack(Items.EMERALD, 1));
            }
            world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_VILLAGER_HURT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
