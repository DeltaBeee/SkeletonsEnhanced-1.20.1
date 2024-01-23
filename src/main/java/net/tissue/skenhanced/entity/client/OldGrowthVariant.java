package net.tissue.skenhanced.entity.client;

import java.util.Arrays;
import java.util.Comparator;

public enum OldGrowthVariant {
    DEFAULT(0),
    GHOST_VARIANT(3);


    private static final OldGrowthVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(OldGrowthVariant::getId)).toArray(OldGrowthVariant[]::new);
    private final int id;

    OldGrowthVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static OldGrowthVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
