package com.yeoxuhang.creaturesfromthelushcave.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreaturesFromTheLushCaveModTab {
    public static final CreativeModeTab TAB = new CreativeModeTab("creatures_from_the_lush_cave") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CreaturesFromTheLushCaveModItems.MOSS_HORSE_ARMROR.get());
        }
    };
}

