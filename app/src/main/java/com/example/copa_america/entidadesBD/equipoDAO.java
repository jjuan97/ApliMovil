package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Dao;
        import android.arch.persistence.room.Delete;
        import android.arch.persistence.room.Insert;
        import android.arch.persistence.room.OnConflictStrategy;
        import android.arch.persistence.room.Query;
        import android.arch.persistence.room.Update;
        import java.util.List;

@Dao
public interface equipoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertequiposBD(List<equiposBD> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertequiposBD(equiposBD item);

    @Update
    public void updateequiposBD(equiposBD item);

    @Delete
    public void deleteequiposBD(equiposBD item);

    @Query("SELECT * FROM equiposBD ORDER BY timestamp DESC")
    public List<equiposBD> loadAllItems();
}