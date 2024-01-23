package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.CrimsonSkeletonModel;
import net.tissue.skenhanced.entity.client.model.WarpedSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.CrimsonSkeleton;
import net.tissue.skenhanced.entity.skeletons.WarpedSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class WarpedSkeletonRenderer extends GeoEntityRenderer<WarpedSkeleton> {
    public WarpedSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WarpedSkeletonModel());
    }
}
