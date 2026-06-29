# Physis API

Physis API is the natural-world concept and metadata API for Orbis Mundi projects.

A shared API providing natural world systems, data and utilities for the Orbis Mundi ecosystem.

It is not a gameplay mod. In this alpha, it only exposes the shared pieces currently needed by my other mods (eg. Thalassa).

## 0.0.2 Scope

This version recenters Physis around natural and physical conditions after extracting spatial, vertical and depth-profile concepts into Topos Core.

Included now:

- Natural/perceptive ocean conditions through `OceanCondition`.
- A publish/read service for Thalassa ocean immersion state through `PhysisOcean`.
- `OceanImmersionState` with Topos-compatible depth profile and depth band ids.
- A shader detection service through `PhysisShaders`.
- Iris detection without a hard Iris dependency.

Compatibility:

- `OceanDepthBand` is deprecated and kept only as an alpha bridge. Depth profiles and bands are now owned conceptually by Topos Core.

## License

Apache-2.0. This is an original API project by andaragk.
