package com.yeoxuhang.creaturesfromthelushcave.registry;

import com.yeoxuhang.creaturesfromthelushcave.CreaturesFromTheLushCaveMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreaturesFromTheLushCaveModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CreaturesFromTheLushCaveMod.MOD_ID);

    public static RegistryObject<SoundEvent> MossWalkerIdle = registerSoundEvent("moss_walker_idle");
    public static RegistryObject<SoundEvent> MossWalkerDeath = registerSoundEvent("moss_walker_death");
    public static RegistryObject<SoundEvent> MossWalkerStep = registerSoundEvent("moss_walker_step");
    public static RegistryObject<SoundEvent> MossWalkerHurt = registerSoundEvent("moss_walker_hurt");

    /**public static final ForgeSoundType CITRINE_LAMP_SOUNDS = new ForgeSoundType(1f, 1f,
            CftlcModSounds.MossWalkerIdle, CftlcModSounds.CITRINE_LAMP_STEP, CftlcModSounds.CITRINE_LAMP_PLACE,
            CftlcModSounds.CITRINE_LAMP_HIT, CftlcModSounds.CITRINE_LAMP_FALL);**/


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CreaturesFromTheLushCaveMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
