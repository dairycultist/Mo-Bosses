package net.dairycultist.mo_bosses.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.Monster;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class OrgetzoitBoss extends FlyingEntity implements Monster {

    public boolean diving = false;

    private Entity target = null;
    private int diveCooldown = 0;
    private int takeFlightCooldown = 0;

    public OrgetzoitBoss(World world) {
        super(world);

        this.texture = "/assets/mo_bosses/stationapi/textures/entity/orgetzoit.png";

        this.height = 14;
        this.width = 4;
    }

    protected void tickLiving() {

        // this code sucks but basically it find the nearest player, floats to them,
        // dives down onto them, makes an explosion, then flies back up to altitude
        if (target == null) {

            target = this.world.getClosestPlayer(this, 100.0);

        } else {

            if (diving) {

                this.move(0, (target.y - this.y - 5) / 20, 0);

                takeFlightCooldown--;

                // make an explosion right as we land
//                if () {
//                    // make an explosion that doesn't damage us
//                }

                if (takeFlightCooldown <= 0) {
                    diving = false;
                    diveCooldown = 500;
                }

            } else {

                if (diveCooldown > 0)
                    diveCooldown--;

                double dx = target.x - this.x;
                double dz = target.z - this.z;

                double dist = MathHelper.sqrt(dx * dx + dz * dz);

                if (dist > 5)
                    this.move(
                            dx / dist * 0.2,
                            (target.y - this.y + 20) / 20,
                            dz / dist * 0.2
                    );
                else if (diveCooldown <= 0) {
                    diving = true;
                    takeFlightCooldown = 200;
                } else
                    this.move(0, (target.y - this.y + 20) / 20, 0);
            }
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
