package me.andaragk.physis.api.shader;

public record ShaderState(boolean shaderModPresent, boolean shaderPackActive, boolean customAquaticParametersSupported, String backendId) {
    public static final ShaderState NONE = new ShaderState(false, false, false, "none");
}
