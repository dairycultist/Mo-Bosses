package net.dairycultist.mo_bosses.boss;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class OrgetzoitBossModel extends EntityModel {

    public ModelPart body;

    public OrgetzoitBossModel() {

        this.body = new ModelPart(16, 16);
        this.body.addCuboid(-4.0F, 0.0F, -2.0F, 8, 12, 4, 1.0F);
        this.body.setPivot(0.0F, 0.0F, 0.0F);
    }

    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);

        this.body.render(scale);
    }

    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {

        this.body.roll = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
}
