
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blossomingvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.blossomingvoid.block.StarStemBlock;
import net.mcreator.blossomingvoid.block.StarBulbBlock;
import net.mcreator.blossomingvoid.BlossomingvoidMod;

public class BlossomingvoidModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BlossomingvoidMod.MODID);
	public static final RegistryObject<Block> STAR_BULB = REGISTRY.register("star_bulb", () -> new StarBulbBlock());
	public static final RegistryObject<Block> STAR_STEM = REGISTRY.register("star_stem", () -> new StarStemBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			StarStemBlock.registerRenderLayer();
		}
	}
}
