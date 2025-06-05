package net.dairycultist.mo_bosses.boss;

import net.minecraft.entity.FlyingEntity;
import net.minecraft.world.World;

public class OrgetzoitBoss extends FlyingEntity {

    public OrgetzoitBoss(World world) {
        super(world);

//        this.texture = "/assets/mo_bosses/stationapi/textures/entity/orgetzoit.png";

        this.boundingBox.set(-1, 0, -1, 1, 2, 1);
    }
}
