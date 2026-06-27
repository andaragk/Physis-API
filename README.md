# Physis API

Physis API is the future core vocabulary layer for Orbis Mundi projects.

A shared API providing natural world systems, data and utilities for the Orbis Mundi ecosystem.

It is not a gameplay mod. In this alpha, it only exposes the shared pieces currently needed by my other mods (eg. Thalassa).

## 0.0.1-alpha Scope

This alpha exists because Thalassa needs a first shared vocabulary without blocking the future Orbis Mundi API.

Included now:

- Ocean-specific alpha vocabulary through `OceanDepthBand` and `OceanCondition`.
- A publish/read service for Thalassa ocean immersion state through `PhysisOcean`.
- A shader detection service through `PhysisShaders`.
- Iris detection without a hard Iris dependency.

## License

Apache-2.0. This is an original API project by andaragk.
