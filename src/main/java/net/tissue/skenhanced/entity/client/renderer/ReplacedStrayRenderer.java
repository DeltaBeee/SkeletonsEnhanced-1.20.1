package net.tissue.skenhanced.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Stray;
import net.tissue.skenhanced.entity.client.model.ReplacedStrayModel;
import net.tissue.skenhanced.entity.skeletons.replaced.ReplacedStray;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedStrayRenderer extends GeoReplacedEntityRenderer<Stray, ReplacedStray> {
    public ReplacedStrayRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReplacedStrayModel(), new ReplacedStray());
    }
}
