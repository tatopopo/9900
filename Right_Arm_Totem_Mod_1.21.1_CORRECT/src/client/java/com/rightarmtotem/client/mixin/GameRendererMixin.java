package com.rightarmtotem.client.mixin;

import com.rightarmtotem.client.RightArmTotemClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "showFloatingItem", at = @At("HEAD"))
    private void rightarmtotem$totemUsed(ItemStack stack, CallbackInfo ci) {
        if (stack.isOf(Items.TOTEM_OF_UNDYING)) {
            RightArmTotemClient.permanentlyHideRightArm();
        }
    }
}
