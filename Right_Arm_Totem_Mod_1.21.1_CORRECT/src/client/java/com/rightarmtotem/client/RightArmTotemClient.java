package com.rightarmtotem.client;

import net.fabricmc.api.ClientModInitializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RightArmTotemClient implements ClientModInitializer {
    private static boolean rightArmGone;
    private static final Path FLAG = Path.of("config", "right-arm-totem-used.txt");

    @Override
    public void onInitializeClient() {
        rightArmGone = Files.exists(FLAG);
    }

    public static boolean isRightArmGone() {
        return rightArmGone;
    }

    public static void permanentlyHideRightArm() {
        if (rightArmGone) return;
        rightArmGone = true;
        try {
            Files.createDirectories(FLAG.getParent());
            Files.writeString(FLAG, "Totem activated. Right arm hidden permanently.\n");
        } catch (IOException ignored) {
        }
    }
}
