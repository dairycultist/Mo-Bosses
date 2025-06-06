package net.dairycultist.mo_bosses.boss;

import net.minecraft.entity.FlyingEntity;
import net.minecraft.world.World;

public class OrgetzoitBoss extends FlyingEntity {

    public OrgetzoitBoss(World world) {
        super(world);

        this.texture = "/assets/mo_bosses/stationapi/textures/entity/orgetzoit.png";

        this.height = 14;
        this.width = 4;
    }
}
