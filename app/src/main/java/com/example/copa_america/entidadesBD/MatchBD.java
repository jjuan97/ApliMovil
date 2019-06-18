package com.example.copa_america.entidadesBD;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.copa_america.R;

@Entity
public class MatchBD {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int imgTeamOne;
    private int imgTeamTwo;
    private String txtTeamOne;
    private String txtTeamTwo;
    private String txtScore;

    public MatchBD(String txtTeamOne, String txtTeamTwo, String txtScore) {
        this.imgTeamOne = selectImg(txtTeamOne);
        this.imgTeamTwo = selectImg(txtTeamTwo);
        this.txtTeamOne = txtTeamOne;
        this.txtTeamTwo = txtTeamTwo;
        this.txtScore = txtScore;
    }



    public int getImgTeamOne() {
        return imgTeamOne;
    }

    public void setImgTeamOne(int imgTeamOne) {
        this.imgTeamOne = imgTeamOne;
    }

    public int getImgTeamTwo() {
        return imgTeamTwo;
    }

    public void setImgTeamTwo(int imgTeamTwo) {
        this.imgTeamTwo = imgTeamTwo;
    }

    public String getTxtTeamOne() {
        return txtTeamOne;
    }

    public void setTxtTeamOne(String txtTeamOne) {
        this.txtTeamOne = txtTeamOne;
    }

    public String getTxtTeamTwo() {
        return txtTeamTwo;
    }

    public void setTxtTeamTwo(String txtTeamTwo) {
        this.txtTeamTwo = txtTeamTwo;
    }

    public String getTxtScore() {
        return txtScore;
    }

    public void setTxtScore(String txtScore) {
        this.txtScore = txtScore;
    }

    private int selectImg(String team) {
        if(team.equals("Argentina"))
            return R.mipmap.argentina;
        else if(team.equals("Bolivia"))
            return R.mipmap.bolivia;
        else if(team.equals("Brasil"))
            return R.mipmap.brasil;
        else if(team.equals("Chile"))
            return R.mipmap.chile;
        else if(team.equals("Colombia"))
            return R.mipmap.colombia;
        else if(team.equals("Ecuador"))
            return R.mipmap.ecuador;
        else if(team.equals("Japón"))
            return R.mipmap.japan;
        else if(team.equals("Catar"))
            return R.mipmap.katar;
        else if(team.equals("Paraguay"))
            return R.mipmap.paraguay;
        else if(team.equals("Perú"))
            return R.mipmap.peru;
        else if(team.equals("Uruguay"))
            return R.mipmap.uruguay;
        else if(team.equals("Venezuela"))
            return R.mipmap.venezuela;
        else
            return R.mipmap.ninguno;
    }
}
