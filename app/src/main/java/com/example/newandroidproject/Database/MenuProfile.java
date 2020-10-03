package com.example.newandroidproject.Database;

import android.provider.BaseColumns;

public final class MenuProfile {
    private MenuProfile() {}

    public static class MenuEntry implements BaseColumns {
        public static final String TABLE_NAME = "Menu";
        public static final String COLUMN_1 = "mName";
        public static final String COLUMN_2 = "price";
        public static final String COLUMN_3 = "description";

    }
}
