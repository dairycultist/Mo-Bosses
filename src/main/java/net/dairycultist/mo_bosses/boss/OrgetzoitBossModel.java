package net.dairycultist.mo_bosses.boss;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class OrgetzoitBossModel extends EntityModel {

    private static final float PI = 3.141592F;

    public ModelPart body;
    public ModelPart[][] tentacles = new ModelPart[8][2];

    public OrgetzoitBossModel() {

        this.body = new ModelPart(16, 16);
        this.body.addCuboid(-8.0F, -24.0F, -8.0F, 16, 24, 16); // pos relative to pivot
        this.body.setPivot(0.0F, 0.0F, 0.0F); // pivot in global space

        for (int i=0; i<8; i++) {

            float a = i * (PI / 4);

            this.tentacles[i][0] = new ModelPart(16, 16);
            this.tentacles[i][0].addCuboid(-2.0F, 0.0F, -2.0F, 4, 16, 4);
            this.tentacles[i][0].setPivot(8.0F * MathHelper.cos(a), 0.0F, 8.0F * MathHelper.sin(a));
            this.tentacles[i][0].yaw = (PI / 2) - a;
        }
    }

    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);

        this.body.render(scale);

        for (ModelPart[] tentacle : this.tentacles) {
            tentacle[0].render(scale);
        }
    }

    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        float a = ((System.currentTimeMillis() % 2000L) / 1000F) * PI;

        for (ModelPart[] tentacle : this.tentacles) {
            tentacle[0].pitch = MathHelper.cos(a) * 0.4F + 0.4F;
        }
    }
}
