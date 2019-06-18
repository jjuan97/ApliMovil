package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MatchDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMatch(List<MatchBD> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMatch(MatchBD item);

    @Update
    public void updateMatch(MatchBD item);

    @Delete
    public void deleteMatch(MatchBD item);

    @Query("SELECT * FROM matchbd")
    public List<MatchBD> loadAllItems();
}
