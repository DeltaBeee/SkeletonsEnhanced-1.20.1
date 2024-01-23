package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.OceanSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.OceanSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OceanSkeletonRenderer extends GeoEntityRenderer<OceanSkeleton> {
    public OceanSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OceanSkeletonModel());
    }
}
