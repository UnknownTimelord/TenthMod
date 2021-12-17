package com.tenth.tenthmod.setup;

import com.tenth.tenthmod.TenthMod;
import com.tenth.tenthmod.blockentities.TormentBlockEntity;
import com.tenth.tenthmod.blockentities.VortexFurnaceEntity;
import com.tenth.tenthmod.blocks.*;
import com.tenth.tenthmod.trees.StarfruitTree;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Register {
    public static final CreativeModeTab TENTH_MOD_TAB = new CreativeModeTab("tenthmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RAW_VORTEX.get());
        }
    };
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TenthMod.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TenthMod.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TenthMod.MOD_ID);
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, TenthMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Misc Items
    public static final RegistryObject<Item> RAW_VORTEX = ITEMS.register("raw_vortex", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Item> VORTEX = ITEMS.register("vortex", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));

    // Special Items
    public static final RegistryObject<Item> TIME_CELL = ITEMS.register("time_cell", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Item> CHRONAL_UTILIZER = ITEMS.register("chronal_utilizer", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Item> STARFRUIT = ITEMS.register("starfruit", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB).food(new FoodProperties.Builder().fast().saturationMod(4).nutrition(4).build())));

    // Misc Blocks
    public static final RegistryObject<Block> VORTEX_ORE = BLOCKS.register("vortex_ore", ()-> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f), UniformInt.of(3, 3)));
    public static final RegistryObject<Item> VORTEX_ORE_ITEM = ITEMS.register("vortex_ore", ()-> new BlockItem(VORTEX_ORE.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> TORMENT_BLOCK = BLOCKS.register("torment_block", ()-> new TormentBlock(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).requiresCorrectToolForDrops().strength(1.0f).noOcclusion()));
    public static final RegistryObject<Item> TORMENT_BLOCK_ITEM = ITEMS.register("torment_block", ()-> new BlockItem(TORMENT_BLOCK.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", ()-> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).requiresCorrectToolForDrops().strength(1.0f)));
    public static final RegistryObject<Item> FLESH_BLOCK_ITEM = ITEMS.register("flesh_block", ()-> new BlockItem(FLESH_BLOCK.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> FLESH_FARMLAND = BLOCKS.register("flesh_farmland", ()-> new FleshFarmland(BlockBehaviour.Properties.of(Material.DIRT).strength(1.0f).sound(SoundType.SOUL_SOIL).randomTicks()));
    public static final RegistryObject<Item> FLESH_FARMLAND_ITEM = ITEMS.register("flesh_farmland", ()-> new BlockItem(FLESH_FARMLAND.get(), new Item.Properties().tab(TENTH_MOD_TAB)));

    // Special Blocks
    public static final RegistryObject<Block> VORTEX_FURNACE = BLOCKS.register("vortex_furnace", ()-> new VortexFurnace(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5.0f).noOcclusion()));
    public static final RegistryObject<Item> VORTEX_FURNACE_ITEM = ITEMS.register("vortex_furnace", ()-> new BlockItem(Register.VORTEX_FURNACE.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<BlockEntityType<VortexFurnaceEntity>> VORTEX_FURNACE_ENTITY = BLOCK_ENTITIES.register("vortex_furnace", ()-> BlockEntityType.Builder.of(VortexFurnaceEntity::new, VORTEX_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TormentBlockEntity>> TORMENT_BLOCK_ENTITY = BLOCK_ENTITIES.register("torment_block", ()-> BlockEntityType.Builder.of(TormentBlockEntity::new, TORMENT_BLOCK.get()).build(null));

    // Carambola/Starfruit Tree
    public static final RegistryObject<Block> STARFRUIT_SAPLING = BLOCKS.register("starfruit_sapling", ()-> new SaplingBlock(new StarfruitTree(), BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().strength(0f)));
    public static final RegistryObject<Item> STARFRUIT_SAPLING_ITEM = ITEMS.register("starfruit_sapling", ()-> new BlockItem(Register.STARFRUIT_SAPLING.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> STARFRUIT_LEAVES = BLOCKS.register("starfruit_leaves", ()-> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).randomTicks().sound(SoundType.GRASS).noOcclusion().strength(1.0f)));
    public static final RegistryObject<Item> STARFRUIT_LEAVES_ITEM = ITEMS.register("starfruit_leaves", ()-> new BlockItem(STARFRUIT_LEAVES.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> CARAMBOLA_LOG = BLOCKS.register("carambola_log", ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of(Blocks.OAK_LOG.defaultBlockState().getMaterial()).sound(SoundType.WOOD).strength(1.0f)));
    public static final RegistryObject<Item> CARAMBOLA_LOG_ITEM = ITEMS.register("carambola_log", ()-> new BlockItem(CARAMBOLA_LOG.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> CARAMBOLA_PLANKS = BLOCKS.register("carambola_planks", ()-> new Block(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(1.0f)));
    public static final RegistryObject<Item> CARAMBOLA_PLANKS_ITEM = ITEMS.register("carambola_planks", ()-> new BlockItem(CARAMBOLA_PLANKS.get(), new Item.Properties().tab(TENTH_MOD_TAB)));

    // Custom Biome Blocks
    public static final RegistryObject<Block> APPLE_GRASS = BLOCKS.register("apple_grass", ()-> new AppleGrass(BlockBehaviour.Properties.of(Material.GRASS).randomTicks().sound(SoundType.GRASS).strength(1.0f)));
    public static final RegistryObject<Item> APPLE_GRASS_ITEM = ITEMS.register("apple_grass", ()-> new BlockItem(APPLE_GRASS.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> APPLE_BUSH = BLOCKS.register("apple_bush", ()-> new AppleBush(BlockBehaviour.Properties.of(Blocks.WHEAT.defaultBlockState().getMaterial()).strength(2.0f).noOcclusion().noCollission().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> APPLE_BUSH_ITEM = ITEMS.register("apple_bush", ()-> new BlockItem(APPLE_BUSH.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
}
