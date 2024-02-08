package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.MushroomSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.MushroomSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MushroomSkeletonRenderer extends GeoEntityRenderer<MushroomSkeleton> {
    public MushroomSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MushroomSkeletonModel());
    }
}
