# Physis API

Physis API is the future core vocabulary layer for Axis Mundi projects.

It is not a gameplay mod. In this alpha, it intentionally avoids defining the broad Axis Mundi vocabulary too early.

## 0.0.1-alpha Scope

This alpha exists because Thalassa needs a first shared vocabulary without blocking the future Axis Mundi API.

Included now:

- Ocean-specific alpha vocabulary through `OceanDepthBand` and `OceanCondition`.
- A publish/read service for Thalassa ocean immersion state through `PhysisOcean`.
- A shader detection service through `PhysisShaders`.
- Iris detection without a hard Iris dependency.

Not included yet:

- Gameplay rules.
- Registries for traits, groups, artifacts, professions, cultures, religions, organizations, or territories.
- Generic concept IDs or generic modifier systems.
- Shader parameter injection.
- Custom uniforms.

## Design Rule

Physis defines the vocabulary. Other mods decide the behavior.

## License

Apache-2.0. This is an original API project by andaragk.
