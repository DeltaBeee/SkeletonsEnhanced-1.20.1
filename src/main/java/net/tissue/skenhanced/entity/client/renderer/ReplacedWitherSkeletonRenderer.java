package net.tissue.skenhanced.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.tissue.skenhanced.entity.client.model.ReplacedSkeletonModel;
import net.tissue.skenhanced.entity.client.model.ReplacedWitherSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.ReplacedSkeleton;
import net.tissue.skenhanced.entity.skeletons.ReplacedWitherSkeleton;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedWitherSkeletonRenderer extends GeoReplacedEntityRenderer<WitherSkeleton, ReplacedWitherSkeleton> {
    public ReplacedWitherSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReplacedWitherSkeletonModel(), new ReplacedWitherSkeleton());
    }

    @Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, ReplacedWitherSkeleton animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        super.scaleModelForRender(1.5f, 1.5f, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }
}
