package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Skeleton;
import net.tissue.skenhanced.entity.client.model.VanillaSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.VanillaSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class VanillaSkeletonRenderer extends GeoReplacedEntityRenderer<Skeleton, VanillaSkeleton> {
    public VanillaSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VanillaSkeletonModel(), new VanillaSkeleton());
    }
}
