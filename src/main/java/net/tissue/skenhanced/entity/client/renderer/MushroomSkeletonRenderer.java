package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.DesertSkeletonModel;
import net.tissue.skenhanced.entity.client.model.MushroomSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import net.tissue.skenhanced.entity.skeletons.MushroomSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class MushroomSkeletonRenderer extends GeoEntityRenderer<MushroomSkeleton> {
    public MushroomSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MushroomSkeletonModel());
    }
}
