package net.tissue.skenhanced.entity.client.gecko.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Skeleton;
import net.tissue.skenhanced.entity.client.gecko.model.GeoVanillaSkeletonModel;
import net.tissue.skenhanced.entity.skeletons.gecko.GeoVanillaSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class GeoVanillaSkeletonRenderer extends GeoReplacedEntityRenderer<Skeleton, GeoVanillaSkeleton> {
    public GeoVanillaSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GeoVanillaSkeletonModel(), new GeoVanillaSkeleton());
    }
}
