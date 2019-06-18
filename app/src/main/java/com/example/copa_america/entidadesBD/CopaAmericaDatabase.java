package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MatchBD.class}, version = 1)
public abstract class CopaAmericaDatabase extends RoomDatabase {
    public abstract MatchDAO MatchDAO();
}
