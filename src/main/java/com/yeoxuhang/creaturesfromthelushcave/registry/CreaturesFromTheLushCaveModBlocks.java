package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.CreaturesFromTheLushCaveMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.MOSS_BLOCK;

public class CreaturesFromTheLushCaveModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreaturesFromTheLushCaveMod.MOD_ID);

    //Moss Bricks
    public static final RegistryObject<Block> MOSS_BRICKS = registerBlock("moss_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.5f)), CreaturesFromTheLushCaveModTab.TAB);

    public static final RegistryObject<Block> MOSS_BRICKS_STAIRS = registerBlock("moss_bricks_stairs",
            () -> new StairBlock(() -> CreaturesFromTheLushCaveModBlocks.MOSS_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.MOSS).strength(0.5f)),
            CreaturesFromTheLushCaveModTab.TAB);
    public static final RegistryObject<Block> MOSS_BRICKS_SLAB = registerBlock("moss_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.5f)), CreaturesFromTheLushCaveModTab.TAB);
    public static final RegistryObject<Block> MOSS_BRICKS_WALL = registerBlock("moss_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.5f)), CreaturesFromTheLushCaveModTab.TAB);

    //Moss Blocks
    public static final RegistryObject<Block> MOSS_BLOCK_STAIRS = registerBlock("moss_block_stairs",
            () -> new StairBlock(() -> MOSS_BLOCK.defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.MOSS).strength(0.5f)),
            CreaturesFromTheLushCaveModTab.TAB);
    public static final RegistryObject<Block> MOSS_BLOCK_SLAB = registerBlock("moss_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.5f)), CreaturesFromTheLushCaveModTab.TAB);
    public static final RegistryObject<Block> MOSS_BLOCK_WALL = registerBlock("moss_block_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.5f)), CreaturesFromTheLushCaveModTab.TAB);

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return CreaturesFromTheLushCaveModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}