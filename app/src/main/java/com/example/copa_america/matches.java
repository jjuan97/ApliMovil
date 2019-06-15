package com.example.copa_america;

public class matches {

    private int imgTeamOne;
    private int imgTeamTwo;
    private String txtTeamOne;
    private String txtTeamTwo;
    private String txtDate;
    private String txtScore;
    private String txtGroup;

    public matches(){

    }

    public matches(int imgTeamOne, int imgTeamTwo, String txtTeamOne, String txtTeamTwo, String txtDate, String txtScore, String txtGroup) {
        this.imgTeamOne = imgTeamOne;
        this.imgTeamTwo = imgTeamTwo;
        this.txtTeamOne = txtTeamOne;
        this.txtTeamTwo = txtTeamTwo;
        this.txtDate = txtDate;
        this.txtScore = txtScore;
        this.txtGroup = txtGroup;
    }

    public int getImgTeamOne() {
        return imgTeamOne;
    }

    public int getImgTeamTwo() {
        return imgTeamTwo;
    }

    public String getTxtTeamOne() {
        return txtTeamOne;
    }

    public String getTxtTeamTwo() {
        return txtTeamTwo;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public String getTxtScore() {
        return txtScore;
    }

    public String getTxtGroup() {
        return txtGroup;
    }

    public void setImgTeamOne(int imgTeamOne) {
        this.imgTeamOne = imgTeamOne;
    }

    public void setImgTeamTwo(int imgTeamTwo) {
        this.imgTeamTwo = imgTeamTwo;
    }

    public void setTxtTeamOne(String txtTeamOne) {
        this.txtTeamOne = txtTeamOne;
    }

    public void setTxtTeamTwo(String txtTeamTwo) {
        this.txtTeamTwo = txtTeamTwo;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public void setTxtScore(String txtScore) {
        this.txtScore = txtScore;
    }

    public void setTxtGroup(String txtGroup) {
        this.txtGroup = txtGroup;
    }
}
