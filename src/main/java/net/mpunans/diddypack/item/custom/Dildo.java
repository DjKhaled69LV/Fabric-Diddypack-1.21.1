package net.mpunans.diddypack.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Dildo extends Item {



    public Dildo(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        if (entity.isMobOrPlayer()) {
            if (!world.isClient) {
                stack.decrement(1);
                entity.setHealth(1.0F);
                world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_VILLAGER_HURT, SoundCategory.PLAYERS, 10.0F, 1.0F);
                return ActionResult.SUCCESS;
            }


        }

        return super.useOnEntity(stack, user, entity, hand);
    }
}
