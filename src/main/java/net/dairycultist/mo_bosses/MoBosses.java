package net.dairycultist.mo_bosses;

import net.dairycultist.mo_bosses.boss.OrgetzoitBoss;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class MoBosses {

    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerEntities(EntityRegister event) {

        event.register(OrgetzoitBoss.class, "Orgetzoit");
    }

//    public static Block COPPER_ORE;
//    public static Block COPPER_BLOCK;
//    public static Item COPPER_INGOT;
//
//    @EventListener
//    public void registerBlocks(BlockRegistryEvent event) {
//
//        COPPER_ORE = new TemplateOreBlock(NAMESPACE.id("copper_ore"), 0)
//                .setHardness(3.0F) // same hardness/resistance as coal
//                .setResistance(5.0F)
//                .setSoundGroup(STONE_SOUND_GROUP)
//                .setTranslationKey(NAMESPACE, "copper_ore");
//
//        COPPER_BLOCK = new TemplateOreStorageBlock(NAMESPACE.id("copper_block"), 0)
//                .setHardness(3.0F)
//                .setResistance(5.0F)
//                .setSoundGroup(STONE_SOUND_GROUP)
//                .setTranslationKey(NAMESPACE, "copper_block");
//    }
//
//    @EventListener
//    public void registerItems(ItemRegistryEvent event) {
//
//        COPPER_INGOT = new TemplateItem(NAMESPACE.id("copper_ingot"))
//                .setTranslationKey(NAMESPACE, "copper_ingot");
//    }
}
