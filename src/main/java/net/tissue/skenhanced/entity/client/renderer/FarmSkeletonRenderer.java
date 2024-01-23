package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.FarmSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.FarmSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FarmSkeletonRenderer extends GeoEntityRenderer<FarmSkeleton> {
    public FarmSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FarmSkeletonModel());
    }
}
