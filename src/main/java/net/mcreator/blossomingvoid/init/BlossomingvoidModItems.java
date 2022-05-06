
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blossomingvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.blossomingvoid.BlossomingvoidMod;

public class BlossomingvoidModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BlossomingvoidMod.MODID);
	public static final RegistryObject<Item> STAR_BULB = block(BlossomingvoidModBlocks.STAR_BULB, BlossomingvoidModTabs.TAB_BLOSSOMING_VOID);
	public static final RegistryObject<Item> STAR_STEM = block(BlossomingvoidModBlocks.STAR_STEM, BlossomingvoidModTabs.TAB_BLOSSOMING_VOID);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
