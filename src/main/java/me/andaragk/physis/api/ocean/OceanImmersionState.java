package me.andaragk.physis.api.ocean;

import java.util.Set;

public record OceanImmersionState(
        boolean underwater,
        int surfaceY,
        int eyeY,
        int depth,
        OceanDepthBand depthBand,
        float fogIntensity,
        float darkness,
        float isolation,
        Set<OceanCondition> conditions
) {
    public static final OceanImmersionState DRY = new OceanImmersionState(false, 0, 0, 0, OceanDepthBand.SURFACE, 0.0F, 0.0F, 0.0F, Set.of());

    public OceanImmersionState {
        depth = Math.max(0, depth);
        if (depthBand == null) {
            depthBand = OceanDepthBand.fromDepth(depth);
        }
        fogIntensity = clamp01(fogIntensity);
        darkness = clamp01(darkness);
        isolation = clamp01(isolation);
        conditions = conditions == null ? Set.of() : Set.copyOf(conditions);
    }

    private static float clamp01(float value) {
        return Math.max(0.0F, Math.min(1.0F, value));
    }
}
