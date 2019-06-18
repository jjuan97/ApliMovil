package com.example.copa_america;

public class Teams {

    private int imgTeam;
    private String txtTeam;
    private String pj;
    private String p;
    private String dg;
    private String position;

    public Teams(){

    }

    public Teams(int imgTeam, String txtTeam) {
        this.imgTeam = imgTeam;
        this.txtTeam = txtTeam;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getDg() {
        return dg;
    }

    public void setDg(String dg) {
        this.dg = dg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
