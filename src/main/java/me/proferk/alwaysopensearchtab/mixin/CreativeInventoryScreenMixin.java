package me.proferk.alwaysopensearchtab.mixin;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeInventoryScreen.class)
public abstract class CreativeInventoryScreenMixin {
	@Shadow protected abstract void setSelectedTab(ItemGroup group);

	@Inject(at = @At("TAIL"), method = "init()V")
	protected void init(CallbackInfo ci) {
		this.setSelectedTab(ItemGroups.SEARCH);
	}
}
