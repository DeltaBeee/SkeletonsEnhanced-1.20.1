package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.ReplacedWitherSkeleton;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ReplacedWitherSkeletonModel extends DefaultedEntityGeoModel<ReplacedWitherSkeleton> {
    public ReplacedWitherSkeletonModel() {
        super(new ResourceLocation(SkEnhanced.MOD_ID, "wither_skeleton"));
    }

    public ResourceLocation buildFormattedModelPath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "geo/" + basePath.getPath() + ".geo.json");
    }

    public ResourceLocation buildFormattedAnimationPath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "animations/" + basePath.getPath() + ".animation.json");
    }

    @Override
    public ResourceLocation buildFormattedTexturePath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "textures/entity/" + basePath.getPath() + ".png");
    }
}
