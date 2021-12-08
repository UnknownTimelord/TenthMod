package com.tenth.tenthmod.world.gen;

import com.tenth.tenthmod.setup.Register;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.Random;


public class ModConfiguredFeatures extends Features {

    public static final ConfiguredFeature<TreeConfiguration, ?> STARFRUIT =
            register("starfruit", Feature.TREE.configured((
                            new TreeConfiguration.TreeConfigurationBuilder(
                                    new SimpleStateProvider(Register.CARAMBOLA_LOG.get().defaultBlockState()),
                                    new StraightTrunkPlacer(2, 1, 2),
                                    new SimpleStateProvider(Register.STARFRUIT_LEAVES.get().defaultBlockState()),
                                    new SimpleStateProvider(Register.STARFRUIT_SAPLING.get().defaultBlockState()),
                                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                                    new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
