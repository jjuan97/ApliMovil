package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Room;
import android.content.Context;

public class equipoDatabaseAccesor {
    private static equipoDatabase equipoDatabaseInstance;
    //Constant about the name assigned to SQLite database
    private static final String EQUIPO_DB_NAME = "team_db";

    private equipoDatabaseAccesor() {
    }

    public static equipoDatabase getInstance(Context context) {
        if (equipoDatabaseInstance == null) {
// Create or open a new SQLite database, and return it as a Room Database instance.
            equipoDatabaseInstance = Room.databaseBuilder(context,
                    equipoDatabase.class, EQUIPO_DB_NAME).build();
        }
        return equipoDatabaseInstance;
    }
}