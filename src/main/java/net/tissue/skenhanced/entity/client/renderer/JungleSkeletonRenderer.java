package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.client.model.JungleSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.JungleSkeleton;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JungleSkeletonRenderer extends GeoEntityRenderer<JungleSkeleton> {
    public JungleSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JungleSkeletonModel());
    }

    @Override
    public ResourceLocation getTextureLocation(JungleSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/jungle_skeleton.png");
    }
}
