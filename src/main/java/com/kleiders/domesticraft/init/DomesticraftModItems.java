
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.kleiders.domesticraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import com.kleiders.domesticraft.DomesticraftMod;

public class DomesticraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DomesticraftMod.MODID);
	public static final RegistryObject<Item> LABRADOR = REGISTRY.register("labrador_spawn_egg",
			() -> new ForgeSpawnEggItem(DomesticraftModEntities.LABRADOR, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
