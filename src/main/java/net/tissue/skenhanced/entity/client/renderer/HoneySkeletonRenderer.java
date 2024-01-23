package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.tissue.skenhanced.entity.client.model.HoneySkeletonModel;
import net.tissue.skenhanced.entity.skeletons.HoneySkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HoneySkeletonRenderer extends GeoEntityRenderer<HoneySkeleton> {
    public HoneySkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HoneySkeletonModel());
    }
}
