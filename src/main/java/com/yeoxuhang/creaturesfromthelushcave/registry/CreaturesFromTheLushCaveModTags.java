package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.CreaturesFromTheLushCaveMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CreaturesFromTheLushCaveModTags {
    public static final TagKey<Block> MOSS_WALKER_SPAWNABLE_ON = makeTag("moss_walker_spawnable_on");

    private static TagKey<Block> makeTag(String id) {
        return BlockTags.create(new ResourceLocation(CreaturesFromTheLushCaveMod.MOD_ID, id));
    }
}