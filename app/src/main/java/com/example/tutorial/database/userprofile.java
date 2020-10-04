package com.example.tutorial.database;

import android.provider.BaseColumns;

public class userprofile {

        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private userprofile() {}

        /* Inner class that defines the table contents */
        public static class users implements BaseColumns {
            public static final String TABLE_NAME = "UserInfo";
            public static final String COLUMN_1 = "full_name";
            public static final String COLUMN_2 = "email";
            public static final String COLUMN_3 = "password";
            public static final String COLUMN_4 = "address";
            public static final String COLUMN_5 = "phone";
        }
        public static class feed implements BaseColumns {
            public static final String TABLE_NAME = "feedback";
            public static final String COLUMN_1 = "full_name";
            public static final String COLUMN_2 = "email";
            public static final String COLUMN_3 = "message";
             }
    }
