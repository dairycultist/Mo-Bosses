package net.dairycultist.mo_bosses;

import net.dairycultist.mo_bosses.boss.OrgetzoitBoss;
import net.dairycultist.mo_bosses.boss.OrgetzoitBossModel;
import net.dairycultist.mo_bosses.boss.OrgetzoitBossRenderer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

public class MoBossesClient {

    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {

        event.renderers.put(OrgetzoitBoss.class, new OrgetzoitBossRenderer(new OrgetzoitBossModel(), 1.0f));
    }
}
