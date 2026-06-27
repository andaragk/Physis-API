package me.andaragk.physis.api.ocean;

public enum OceanDepthBand {
    SURFACE(0),
    LITTORAL_EPIPELAGIC(1),
    MESOPELAGIC_BATHYAL(16),
    BATHYPELAGIC_MIDNIGHT(46),
    ABYSSOPELAGIC(76),
    HADAL(111);

    private final int startDepth;

    OceanDepthBand(int startDepth) {
        this.startDepth = startDepth;
    }

    public int startDepth() {
        return startDepth;
    }

    public static OceanDepthBand fromDepth(int depth) {
        if (depth >= HADAL.startDepth) {
            return HADAL;
        }
        if (depth >= ABYSSOPELAGIC.startDepth) {
            return ABYSSOPELAGIC;
        }
        if (depth >= BATHYPELAGIC_MIDNIGHT.startDepth) {
            return BATHYPELAGIC_MIDNIGHT;
        }
        if (depth >= MESOPELAGIC_BATHYAL.startDepth) {
            return MESOPELAGIC_BATHYAL;
        }
        if (depth >= LITTORAL_EPIPELAGIC.startDepth) {
            return LITTORAL_EPIPELAGIC;
        }
        return SURFACE;
    }
}
