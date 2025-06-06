package net.dairycultist.mo_bosses.boss;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.opengl.GL11;

public class OrgetzoitBossRenderer extends LivingEntityRenderer {

    public OrgetzoitBossRenderer(EntityModel entityModel, float shadowRadius) {
        super(entityModel, shadowRadius);
    }

    protected void applyScale(LivingEntity entity, float f) {

        this.model.riding = ((OrgetzoitBoss) entity).diving;

        GL11.glScalef(4.0F, 4.0F, 4.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
