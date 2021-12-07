package com.tenth.tenthmod.setup;

import com.tenth.tenthmod.TenthMod;
import com.tenth.tenthmod.blockentities.TormentBlockEntity;
import com.tenth.tenthmod.blockentities.VortexFurnaceEntity;
import com.tenth.tenthmod.blocks.TormentBlock;
import com.tenth.tenthmod.blocks.VortexFurnace;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TenthMod.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TenthMod.MOD_ID);
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RAW_VORTEX = ITEMS.register("raw_vortex", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Item> VORTEX = ITEMS.register("vortex", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));

    // Special Items
    public static final RegistryObject<Item> TIME_CELL = ITEMS.register("time_cell", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Item> CHRONAL_UTILIZER = ITEMS.register("chronal_utilizer", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));

    // Blocks
    public static final RegistryObject<Block> VORTEX_ORE = BLOCKS.register("vortex_ore", ()-> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5.0f), UniformInt.of(3, 3)));
    public static final RegistryObject<Item> VORTEX_ORE_ITEM = ITEMS.register("vortex_ore", ()-> new BlockItem(Register.VORTEX_ORE.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> TORMENT_BLOCK = BLOCKS.register("torment_block", ()-> new TormentBlock(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).requiresCorrectToolForDrops().strength(1.0f).noOcclusion()));
    public static final RegistryObject<Item> TORMENT_BLOCK_ITEM = ITEMS.register("torment_block", ()-> new BlockItem(Register.TORMENT_BLOCK.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<Block> FLESH_BLOCK = BLOCKS.register("flesh_block", ()-> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).requiresCorrectToolForDrops().strength(1.0f)));
    public static final RegistryObject<Item> FLESH_BLOCK_ITEM = ITEMS.register("flesh_block", ()-> new BlockItem(Register.FLESH_BLOCK.get(), new Item.Properties().tab(TENTH_MOD_TAB)));

    // Special Blocks
    public static final RegistryObject<Block> VORTEX_FURNACE = BLOCKS.register("vortex_furnace", ()-> new VortexFurnace(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5.0f).noOcclusion()));
    public static final RegistryObject<Item> VORTEX_FURNACE_ITEM = ITEMS.register("vortex_furnace", ()-> new BlockItem(Register.VORTEX_FURNACE.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
    public static final RegistryObject<BlockEntityType<VortexFurnaceEntity>> VORTEX_FURNACE_ENTITY = BLOCK_ENTITIES.register("vortex_furnace", ()-> BlockEntityType.Builder.of(VortexFurnaceEntity::new, VORTEX_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TormentBlockEntity>> TORMENT_BLOCK_ENTITY = BLOCK_ENTITIES.register("torment_block", ()-> BlockEntityType.Builder.of(TormentBlockEntity::new, TORMENT_BLOCK.get()).build(null));
}
