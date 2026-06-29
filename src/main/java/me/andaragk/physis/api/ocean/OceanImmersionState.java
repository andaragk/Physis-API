package me.andaragk.physis.api.ocean;

import java.util.Set;
import net.minecraft.resources.ResourceLocation;

public record OceanImmersionState(
        boolean underwater,
        int surfaceY,
        int eyeY,
        int depth,
        ResourceLocation depthProfileId,
        ResourceLocation depthBandId,
        @Deprecated(forRemoval = false, since = "0.0.2")
        OceanDepthBand depthBand,
        float fogIntensity,
        float darkness,
        float isolation,
        Set<OceanCondition> conditions
) {
    public static final ResourceLocation UNKNOWN_DEPTH_PROFILE = ResourceLocation.fromNamespaceAndPath("physisapi", "unknown");
    public static final ResourceLocation UNKNOWN_DEPTH_BAND = ResourceLocation.fromNamespaceAndPath("physisapi", "unknown");
    public static final OceanImmersionState DRY = new OceanImmersionState(false, 0, 0, 0, UNKNOWN_DEPTH_PROFILE, UNKNOWN_DEPTH_BAND, OceanDepthBand.SURFACE, 0.0F, 0.0F, 0.0F, Set.of());

    @Deprecated(forRemoval = false, since = "0.0.2")
    public OceanImmersionState(
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
        this(
                underwater,
                surfaceY,
                eyeY,
                depth,
                ResourceLocation.fromNamespaceAndPath("toposcore", "oceanic"),
                ResourceLocation.fromNamespaceAndPath("toposcore", "oceanic/" + legacyDepthBandPath(depthBand, depth)),
                depthBand,
                fogIntensity,
                darkness,
                isolation,
                conditions
        );
    }

    public OceanImmersionState {
        depth = Math.max(0, depth);
        depthProfileId = depthProfileId == null ? UNKNOWN_DEPTH_PROFILE : depthProfileId;
        depthBandId = depthBandId == null ? UNKNOWN_DEPTH_BAND : depthBandId;
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

    private static String legacyDepthBandPath(OceanDepthBand depthBand, int depth) {
        OceanDepthBand safeBand = depthBand == null ? OceanDepthBand.fromDepth(depth) : depthBand;
        return switch (safeBand) {
            case SURFACE -> "surface";
            case LITTORAL_EPIPELAGIC -> "littoral_epipelagic";
            case MESOPELAGIC_BATHYAL -> "mesopelagic_bathyal";
            case BATHYPELAGIC_MIDNIGHT -> "bathypelagic_midnight";
            case ABYSSOPELAGIC -> "abyssopelagic";
            case HADAL -> "hadal";
        };
    }
}
