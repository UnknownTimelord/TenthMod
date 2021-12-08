package com.tenth.tenthmod;

import com.tenth.tenthmod.setup.Register;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TenthMod.MOD_ID)
public class TenthMod {

    public static final String MOD_ID = "tenthmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public TenthMod() {
        Register.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::setupClient);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(Register.VORTEX_FURNACE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Register.TORMENT_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(Register.STARFRUIT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Register.STARFRUIT_LEAVES.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
