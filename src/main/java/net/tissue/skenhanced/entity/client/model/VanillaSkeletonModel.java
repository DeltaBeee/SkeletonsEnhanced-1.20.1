package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.VanillaSkeleton;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class VanillaSkeletonModel extends DefaultedEntityGeoModel<VanillaSkeleton> {
    public VanillaSkeletonModel() {
        super(new ResourceLocation(SkEnhanced.MOD_ID, "skeleton"));
    }
}
