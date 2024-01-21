package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.client.model.DesertSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DesertSkeletonRenderer extends GeoEntityRenderer<DesertSkeleton> {
    public DesertSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DesertSkeletonModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DesertSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/desert_skeleton.png");
    }
}
