package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Skeleton;
import net.tissue.skenhanced.entity.client.model.ReplacedSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.ReplacedSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedSkeletonRenderer extends GeoReplacedEntityRenderer<Skeleton, ReplacedSkeleton> {
    public ReplacedSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReplacedSkeletonModel(), new ReplacedSkeleton());
    }
}
