package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.DesertSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class DesertSkeletonRenderer extends GeoEntityRenderer<DesertSkeleton> {
    public DesertSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DesertSkeletonModel());
        addRenderLayer(new ItemArmorGeoLayer<>(this));
    }
}
