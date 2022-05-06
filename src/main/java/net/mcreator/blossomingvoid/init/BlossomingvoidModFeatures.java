
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blossomingvoid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.blossomingvoid.world.features.ores.StarStemFeature;
import net.mcreator.blossomingvoid.world.features.ores.StarBulbFeature;
import net.mcreator.blossomingvoid.world.features.BulbFeature;
import net.mcreator.blossomingvoid.BlossomingvoidMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BlossomingvoidModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, BlossomingvoidMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> STAR_BULB = register("star_bulb", StarBulbFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, StarBulbFeature.GENERATE_BIOMES, StarBulbFeature::placedFeature));
	public static final RegistryObject<Feature<?>> STAR_STEM = register("star_stem", StarStemFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, StarStemFeature.GENERATE_BIOMES, StarStemFeature::placedFeature));
	public static final RegistryObject<Feature<?>> BULB = register("bulb", BulbFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, BulbFeature.GENERATE_BIOMES, BulbFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
