package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.CrimsonSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.CrimsonSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class CrimsonSkeletonRenderer extends GeoEntityRenderer<CrimsonSkeleton> {
    public CrimsonSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrimsonSkeletonModel());
        addRenderLayer(new ItemArmorGeoLayer<>(this));
    }
}
