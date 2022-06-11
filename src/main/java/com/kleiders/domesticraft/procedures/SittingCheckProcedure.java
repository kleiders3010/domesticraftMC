package com.kleiders.domesticraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.kleiders.domesticraft.DomesticraftMod;

public class SittingCheckProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DomesticraftMod.LOGGER.warn("Failed to load dependency entity for procedure SittingCheck!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("sitting") == true) {
			return false;
		}
		return true;
	}
}
