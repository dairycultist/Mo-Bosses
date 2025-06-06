package net.dairycultist.mo_bosses.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.Monster;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class OrgetzoitBoss extends FlyingEntity implements Monster {

    private Entity target = null;
    private double followHeight = 20; // for swooping

    public OrgetzoitBoss(World world) {
        super(world);

        this.texture = "/assets/mo_bosses/stationapi/textures/entity/orgetzoit.png";

        this.height = 14;
        this.width = 4;
    }

    protected void tickLiving() {

        if (target == null) {

            target = this.world.getClosestPlayer(this, 100.0);

        } else {

            double dx = target.x - this.x;
            double dz = target.z - this.z;

            double dist = MathHelper.sqrt(dx * dx + dz * dz);

            if (dist > 2)
                this.move(
                        dx / dist * 0.05,
                        (target.y - this.y + followHeight) / 20,
                        dz / dist * 0.05
                );
            else
                this.move(0, (target.y - this.y + followHeight) / 20, 0);
        }
    }

    protected String getRandomSound() {
        return "mob.ghast.moan";
    }

    protected String getHurtSound() {
        return "mob.ghast.scream";
    }

    protected String getDeathSound() {
        return "mob.ghast.death";
    }

    protected int getDroppedItemId() {
        return Item.GUNPOWDER.id;
    }

    protected float getSoundVolume() {
        return 10.0F;
    }
}
