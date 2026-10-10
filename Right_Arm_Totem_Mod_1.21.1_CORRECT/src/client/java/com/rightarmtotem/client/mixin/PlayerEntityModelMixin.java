package com.rightarmtotem.client.mixin;

import com.rightarmtotem.client.RightArmTotemClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> {
    @Inject(method = "setAngles", at = @At("TAIL"))
    private void rightarmtotem$hideThirdPersonRightArm(
            T entity,
            float limbAngle,
            float limbDistance,
            float animationProgress,
            float headYaw,
            float headPitch,
            CallbackInfo ci) {
        if (RightArmTotemClient.isRightArmGone()
                && MinecraftClient.getInstance().player != null
                && entity == MinecraftClient.getInstance().player) {
            PlayerEntityModel<?> model = (PlayerEntityModel<?>)(Object)this;
            model.rightArm.visible = false;
            model.rightSleeve.visible = false;
        }
    }
}
