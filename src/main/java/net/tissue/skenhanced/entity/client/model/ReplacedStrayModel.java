package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.ReplacedSkeleton;
import net.tissue.skenhanced.entity.skeletons.ReplacedStray;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ReplacedStrayModel extends DefaultedEntityGeoModel<ReplacedStray> {
    public ReplacedStrayModel() {
        super(new ResourceLocation(SkEnhanced.MOD_ID, "stray"));
    }

    public ResourceLocation buildFormattedModelPath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "geo/" + basePath.getPath() + ".geo.json");
    }

    public ResourceLocation buildFormattedAnimationPath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "animations/skeleton.animation.json");
    }

    @Override
    public ResourceLocation buildFormattedTexturePath(ResourceLocation basePath) {
        return new ResourceLocation(basePath.getNamespace(), "textures/entity/" + basePath.getPath() + ".png");
    }
}
