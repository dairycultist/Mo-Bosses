package net.dairycultist.mo_bosses.boss;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class OrgetzoitBossModel extends EntityModel {

    private static final float PI = 3.141592F;

    public ModelPart body;
    public ModelPart[][] tentacles = new ModelPart[8][2];

    public OrgetzoitBossModel() {

        this.body = new ModelPart(0, 4);
        this.body.addCuboid(-6.0F, -16.0F, -6.0F, 12, 16, 12); // pos relative to pivot
        this.body.setPivot(0.0F, 16.0F, 0.0F); // pivot in global space

        for (int i=0; i<8; i++) {

            float a = i * (PI / 4);

            this.tentacles[i][0] = new ModelPart(48, 0);
            this.tentacles[i][0].addCuboid(-2.0F, 0.0F, -2.0F, 4, 14, 4);
            this.tentacles[i][0].setPivot(6.0F * MathHelper.cos(a), 16.0F, 6.0F * MathHelper.sin(a));
            this.tentacles[i][0].yaw = (PI / 2) - a;

            this.tentacles[i][1] = new ModelPart(0, 0);
            this.tentacles[i][1].addCuboid(-1.0F, 0.0F, -1.0F, 2, 14, 2);
            this.tentacles[i][1].yaw = (PI / 2) - a;
        }
    }

    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);

        this.body.render(scale);

        for (ModelPart[] tentacle : this.tentacles) {
            tentacle[0].render(scale);
            tentacle[1].render(scale);
        }
    }

    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        float a = ((System.currentTimeMillis() % 8000L) / 1000F) * PI;

        body.roll = MathHelper.cos(a / 2) * 0.08F;

        for (ModelPart[] tentacle : this.tentacles) {
            tentacle[0].pitch = MathHelper.cos(a) * 0.4F + 0.4F;
            tentacle[1].pitch = MathHelper.cos(a - 1.0F) * 0.4F + 0.4F;

            // [1] needs to be positioned at the tip of [0]
            tentacle[1].setPivot(
                    tentacle[0].pivotX + MathHelper.sin(tentacle[0].pitch) * 14 * MathHelper.sin(tentacle[0].yaw),
                    tentacle[0].pivotY + MathHelper.cos(tentacle[0].pitch) * 14,
                    tentacle[0].pivotZ + MathHelper.sin(tentacle[0].pitch) * 14 * MathHelper.cos(tentacle[0].yaw)
            );
        }
    }
}
