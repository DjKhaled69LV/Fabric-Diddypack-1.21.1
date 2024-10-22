package net.mpunans.diddypack.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SNUS = new FoodComponent.Builder().nutrition(0).saturationModifier(1.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 10, 0), 0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 3), 0.8F).build();
    public static final FoodComponent CUM = new FoodComponent.Builder().nutrition(5).saturationModifier(5.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 500, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 500, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 500, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1000, 0), 1.0F).build();
}
