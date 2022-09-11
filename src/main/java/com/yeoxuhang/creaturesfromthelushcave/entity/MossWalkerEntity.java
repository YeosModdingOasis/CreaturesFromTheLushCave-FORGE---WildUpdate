package com.yeoxuhang.creaturesfromthelushcave.entity;

import com.yeoxuhang.creaturesfromthelushcave.registry.CreaturesFromTheLushCaveModEntities;
import com.yeoxuhang.creaturesfromthelushcave.registry.CreaturesFromTheLushCaveModItems;
import com.yeoxuhang.creaturesfromthelushcave.registry.CreaturesFromTheLushCaveModSounds;
import com.yeoxuhang.creaturesfromthelushcave.registry.CreaturesFromTheLushCaveModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Objects;

import static net.minecraft.world.entity.monster.Monster.isDarkEnoughToSpawn;

public class MossWalkerEntity extends Animal {
    public MossWalkerEntity(EntityType<? extends MossWalkerEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    public static boolean checkWalkerSpawnRules(EntityType<MossWalkerEntity> mosswalker, LevelAccessor world, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return world.getBlockState(pos.below()).is(CreaturesFromTheLushCaveModTags.MOSS_WALKER_SPAWNABLE_ON) && isDarkEnoughToSpawn((ServerLevelAccessor) world, pos, random);
    }

    public static AttributeSupplier setAttributes() {
        return MossWalkerEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0f)
                .add(Attributes.ATTACK_SPEED, 0.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 32D)
                .build();
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 0.9D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(CreaturesFromTheLushCaveModItems.MOSS_WHEAT.get()), false));
    }

    @Override
    @Nullable
    public MossWalkerEntity getBreedOffspring(ServerLevel serverLevel, AgeableMob p_146744_) {
        return CreaturesFromTheLushCaveModEntities.MOSS_WALKER.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Objects.equals(CreaturesFromTheLushCaveModItems.MOSS_WHEAT.get(), stack.getItem());
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.MOSS_STEP, 0.15F, 1.0F);
    }
    protected SoundEvent getAmbientSound() {
        return CreaturesFromTheLushCaveModSounds.MossWalkerIdle.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return CreaturesFromTheLushCaveModSounds.MossWalkerHurt.get();
    }

    protected SoundEvent getDeathSound() {
        return CreaturesFromTheLushCaveModSounds.MossWalkerDeath.get();
    }

    protected float getSoundVolume() {
        return 5F;
    }
}
