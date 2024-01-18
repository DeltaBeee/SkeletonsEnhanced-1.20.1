package net.tissue.skenhanced.entity.client.gecko.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.gecko.GeoVanillaSkeleton;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeoVanillaSkeletonModel extends DefaultedEntityGeoModel<GeoVanillaSkeleton> {
    public GeoVanillaSkeletonModel() {
        super(new ResourceLocation(SkEnhanced.MOD_ID, "skeleton"));
    }
}
