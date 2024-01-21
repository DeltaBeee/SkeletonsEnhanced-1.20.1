package net.tissue.skenhanced.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.OldGrowthSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OldGrowthSkeletonRenderer extends GeoEntityRenderer<OldGrowthSkeleton> {






    public OldGrowthSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new OldGrowthSkeletonModel());

    }





    @Override
    public void render(OldGrowthSkeleton entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        poseStack.scale(1.5F, 1.5F, 1.5F);
        this.animatable = entity;

VertexConsumer vertex = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(animatable)));



        defaultRender(poseStack, entity, bufferSource, null, vertex, entityYaw, partialTick, packedLight);

    }
}