package me.andaragk.physis.api.ocean;

public final class PhysisOcean {
    private static OceanImmersionProvider provider = () -> OceanImmersionState.DRY;

    private PhysisOcean() {
    }

    public static void registerProvider(OceanImmersionProvider oceanProvider) {
        provider = oceanProvider == null ? () -> OceanImmersionState.DRY : oceanProvider;
    }

    public static OceanImmersionState currentState() {
        return provider.currentState();
    }
}
