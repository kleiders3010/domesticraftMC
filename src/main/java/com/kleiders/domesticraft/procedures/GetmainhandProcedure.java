package com.kleiders.domesticraft.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class GetmainhandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack ewe = ItemStack.EMPTY;
		ewe = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
	}
}
