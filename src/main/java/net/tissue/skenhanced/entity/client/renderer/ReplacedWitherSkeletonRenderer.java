package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.tissue.skenhanced.entity.client.model.ReplacedSkeletonModel;
import net.tissue.skenhanced.entity.client.model.ReplacedWitherSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.ReplacedSkeleton;
import net.tissue.skenhanced.entity.skeletons.ReplacedWitherSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedWitherSkeletonRenderer extends GeoReplacedEntityRenderer<WitherSkeleton, ReplacedWitherSkeleton> {
    public ReplacedWitherSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReplacedWitherSkeletonModel(), new ReplacedWitherSkeleton());
    }
}
