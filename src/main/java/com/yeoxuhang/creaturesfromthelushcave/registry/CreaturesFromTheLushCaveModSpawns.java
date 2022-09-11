package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.entity.MossWalkerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

public class CreaturesFromTheLushCaveModSpawns {
    public static void registerSpawns() {
        registerSpawn(CreaturesFromTheLushCaveModEntities.MOSS_WALKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MossWalkerEntity::checkWalkerSpawnRules);
    }

    public static <T extends Mob> void registerSpawn(EntityType<T> entityType, SpawnPlacements.Type decoratorType, Heightmap.Types heightMapType, SpawnPlacements.SpawnPredicate<T> predicate) {
        SpawnPlacements.register(entityType, decoratorType, heightMapType, predicate);
    }
}
