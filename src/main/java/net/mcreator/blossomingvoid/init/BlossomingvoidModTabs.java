
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blossomingvoid.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BlossomingvoidModTabs {
	public static CreativeModeTab TAB_BLOSSOMING_VOID;

	public static void load() {
		TAB_BLOSSOMING_VOID = new CreativeModeTab("tabblossoming_void") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.END_STONE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
