package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.CaveSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.CaveSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CaveSkeletonRenderer extends GeoEntityRenderer<CaveSkeleton> {
    public CaveSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CaveSkeletonModel());
    }
}
