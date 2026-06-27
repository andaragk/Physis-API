package me.andaragk.physis.impl.shader;

import java.lang.reflect.Method;
import me.andaragk.physis.api.shader.ShaderBridge;
import me.andaragk.physis.api.shader.ShaderState;
import net.neoforged.fml.ModList;

public final class IrisDetectionBridge implements ShaderBridge {
    @Override
    public String id() {
        return "iris";
    }

    @Override
    public ShaderState state() {
        if (!ModList.get().isLoaded("iris")) {
            return ShaderState.NONE;
        }

        return new ShaderState(true, isShaderPackActive(), false, id());
    }

    private boolean isShaderPackActive() {
        try {
            Class<?> apiClass = Class.forName("net.irisshaders.iris.api.v0.IrisApi");
            Method getInstance = apiClass.getMethod("getInstance");
            Object api = getInstance.invoke(null);
            Method isShaderPackInUse = apiClass.getMethod("isShaderPackInUse");
            return Boolean.TRUE.equals(isShaderPackInUse.invoke(api));
        } catch (ReflectiveOperationException | LinkageError ignored) {
            return false;
        }
    }
}
