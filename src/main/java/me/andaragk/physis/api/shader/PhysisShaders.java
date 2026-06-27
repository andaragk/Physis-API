package me.andaragk.physis.api.shader;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.andaragk.physis.impl.shader.IrisDetectionBridge;

public final class PhysisShaders {
    private static final List<ShaderBridge> BRIDGES = new CopyOnWriteArrayList<>();

    static {
        registerBridge(new IrisDetectionBridge());
    }

    private PhysisShaders() {
    }

    public static void registerBridge(ShaderBridge bridge) {
        if (bridge != null) {
            BRIDGES.add(bridge);
        }
    }

    public static ShaderState currentState() {
        return BRIDGES.stream()
                .map(ShaderBridge::state)
                .filter(ShaderState::shaderModPresent)
                .max(Comparator.comparing(ShaderState::shaderPackActive))
                .orElse(ShaderState.NONE);
    }
}
