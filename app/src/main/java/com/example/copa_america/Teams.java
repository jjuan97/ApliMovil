package com.example.copa_america;

public class Teams {

    private int imgTeam;
    private String txtTeam;

    public Teams(){

    }

    public Teams(int imgTeam, String txtTeam) {
        this.imgTeam = imgTeam;
        this.txtTeam = txtTeam;
    }

    public int getImgTeam() {
        return imgTeam;
    }

    public String getTxtTeam() {
        return txtTeam;
    }

    public void setImgTeam(int imgTeam) {
        this.imgTeam = imgTeam;
    }

    public void setTxtTeam(String txtTeam) {
        this.txtTeam = txtTeam;
    }
}
