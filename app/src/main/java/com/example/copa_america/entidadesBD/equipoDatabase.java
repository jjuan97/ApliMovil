package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {equiposBD.class}, version = 1)
public abstract class equipoDatabase extends RoomDatabase {
    public abstract equipoDAO equipoDAO();
}
