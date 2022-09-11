package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.CreaturesFromTheLushCaveMod;
import com.yeoxuhang.creaturesfromthelushcave.entity.MossWalkerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreaturesFromTheLushCaveModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreaturesFromTheLushCaveMod.MOD_ID);

    public static final RegistryObject<EntityType<MossWalkerEntity>> MOSS_WALKER = ENTITY_TYPES.register("moss_walker",
            () -> EntityType.Builder.of(MossWalkerEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 3f)
                    .build(new ResourceLocation(CreaturesFromTheLushCaveMod.MOD_ID, "moss_walker").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
