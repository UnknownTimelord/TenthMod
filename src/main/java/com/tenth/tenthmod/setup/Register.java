package com.tenth.tenthmod.setup;

import com.tenth.tenthmod.TenthMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
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
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // Items
    public static final RegistryObject<Item> RAW_VORTEX = ITEMS.register("raw_vortex", ()-> new Item(new Item.Properties().tab(TENTH_MOD_TAB)));

    // Blocks & BlockItems
    public static final RegistryObject<Block> VORTEX_ORE = BLOCKS.register("vortex_ore", ()-> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5.0f), UniformInt.of(3, 3)));
    public static final RegistryObject<Item> VORTEX_ORE_ITEM = ITEMS.register("vortex_ore", ()-> new BlockItem(Register.VORTEX_ORE.get(), new Item.Properties().tab(TENTH_MOD_TAB)));
}
