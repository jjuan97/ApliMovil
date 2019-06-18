package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Room;
import android.content.Context;

public class CopaAmericaDatabaseAccesor {
    private static CopaAmericaDatabase copaAmericaDatabaseInstance;
    //Constant about the name assigned to SQLite database
    private static final String COPA_AMERICA_DB_NAME = "copa_america_db";

    private CopaAmericaDatabaseAccesor() {
    }

    public static CopaAmericaDatabase getInstance(Context context) {
        if (copaAmericaDatabaseInstance == null) {
            // Create or open a new SQLite database, and return it as a Room Database instance.
            copaAmericaDatabaseInstance = Room.databaseBuilder(context,
                    CopaAmericaDatabase.class, COPA_AMERICA_DB_NAME).build();
        }
        return copaAmericaDatabaseInstance;
    }
}
