package me.andaragk.physis.api.ocean;

@FunctionalInterface
public interface OceanImmersionProvider {
    OceanImmersionState currentState();
}
