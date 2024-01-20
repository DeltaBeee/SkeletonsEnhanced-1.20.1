package net.tissue.skenhanced.entity.client.gecko.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.client.gecko.model.IceSpikesSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IceSpikeSkeletonRenderer extends GeoEntityRenderer<IceSpikesSkeleton> {
    public IceSpikeSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IceSpikesSkeletonModel());
    }

    @Override
    public ResourceLocation getTextureLocation(IceSpikesSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/ice_spikes_skeleton_texture.png");
    }

    @Override
    public void render(IceSpikesSkeleton entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}