package com.kleiders.domesticraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.kleiders.domesticraft.DomesticraftMod;

public class LabradorRightClickedOnEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DomesticraftMod.LOGGER.warn("Failed to load dependency entity for procedure LabradorRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getBoolean("sitting")) {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putBoolean("sitting", (false));
			} else {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putBoolean("sitting", (true));
			}
		}
	}
}
