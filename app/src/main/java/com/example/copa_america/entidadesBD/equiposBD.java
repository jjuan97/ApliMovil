package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class equiposBD {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String info;
    private long timestamp;

    public equiposBD(String _info) {
        this(_info, java.lang.System.currentTimeMillis());
    }

    public equiposBD(String info, long timestamp) {
        this.info = info;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }


    public String getinfo() {
        return info;
    }

    public void setinfo(String info) {
        this.info = info;
    }

    public long getTimestamp() {
        return java.lang.System.currentTimeMillis();
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}