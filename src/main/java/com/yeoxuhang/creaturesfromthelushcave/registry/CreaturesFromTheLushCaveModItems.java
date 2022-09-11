package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.CreaturesFromTheLushCaveMod;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreaturesFromTheLushCaveModItems {


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreaturesFromTheLushCaveMod.MOD_ID);

    //SpawnEgg
    public static final RegistryObject<ForgeSpawnEggItem> MOSS_WALKER_SPAWN_EGG = ITEMS.register("moss_walker_spawn_egg",
            () -> new ForgeSpawnEggItem(CreaturesFromTheLushCaveModEntities.MOSS_WALKER,2179604, 8956196,
                    new Item.Properties().tab(CreaturesFromTheLushCaveModTab.TAB)));

    public static final RegistryObject<Item> MOSS_WHEAT = ITEMS.register("wheat_with_moss",
            () -> new Item(new Item.Properties().tab(CreaturesFromTheLushCaveModTab.TAB).stacksTo(64)));

    public static final RegistryObject<Item> MOSS_HORSE_ARMROR = ITEMS.register("moss_horse_armor",
            () -> new HorseArmorItem(5, "moss", new Item.Properties().tab(CreaturesFromTheLushCaveModTab.TAB).stacksTo(1)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}