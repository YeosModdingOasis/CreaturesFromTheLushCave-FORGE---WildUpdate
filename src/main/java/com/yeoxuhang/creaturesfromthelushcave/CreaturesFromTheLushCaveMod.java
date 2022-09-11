package com.yeoxuhang.creaturesfromthelushcave;

import com.yeoxuhang.creaturesfromthelushcave.client.entity.model.MossWalkerModel;
import com.yeoxuhang.creaturesfromthelushcave.client.entity.render.MossWalkerRenderer;
import com.yeoxuhang.creaturesfromthelushcave.entity.MossWalkerEntity;
import com.yeoxuhang.creaturesfromthelushcave.registry.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(CreaturesFromTheLushCaveMod.MOD_ID)
public class CreaturesFromTheLushCaveMod {
    public static final String MOD_ID = "creaturesfromthelushcave";

    public CreaturesFromTheLushCaveMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreaturesFromTheLushCaveModItems.register(eventBus);
        CreaturesFromTheLushCaveModEntities.register(eventBus);
        CreaturesFromTheLushCaveModSounds.register(eventBus);
        CreaturesFromTheLushCaveModBlocks.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerLayers);
        eventBus.addListener(this::entityAttributeEvent);
        eventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(CreaturesFromTheLushCaveModEntities.MOSS_WALKER.get(), MossWalkerRenderer::new);
    }

    private void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MossWalkerModel.LAYER_LOCATION, MossWalkerModel::createBodyLayer);
    }

    public void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(CreaturesFromTheLushCaveModEntities.MOSS_WALKER.get(), MossWalkerEntity.setAttributes());
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(CreaturesFromTheLushCaveModSpawns::registerSpawns);
    }
}
