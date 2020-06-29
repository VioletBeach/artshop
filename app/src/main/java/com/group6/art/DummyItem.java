package com.group6.art;

public class DummyItem {

    int intDummyImage;
    int intDummyWriter;
    String strDummyTitle;
    String strDummySubtitle;
    String strDummyScore;

    public DummyItem(int intDummyImage, String strDummyTitle, String strDummySubtitle,String strDummyScore,int intDummyWriter) {
        this.intDummyImage = intDummyImage;
        this.strDummyTitle = strDummyTitle;
        this.strDummySubtitle = strDummySubtitle;
        this.strDummyScore = strDummyScore;
        this.intDummyWriter = intDummyWriter;
    }

    public DummyItem(int intDummyImage, String strDummyTitle, String strDummySubtitle,String strDummyScore) {
        this.intDummyImage = intDummyImage;
        this.strDummyTitle = strDummyTitle;
        this.strDummySubtitle = strDummySubtitle;
        this.strDummyScore = strDummyScore;
    }
    public DummyItem(int intDummyImage, String strDummyTitle, String strDummySubtitle) {
        this.intDummyImage = intDummyImage;
        this.strDummyTitle = strDummyTitle;
        this.strDummySubtitle = strDummySubtitle;
    }

    public int getIntDummyImage() {
        return intDummyImage;
    }

    public void setIntDummyImage(int intDummyImage) {
        this.intDummyImage = intDummyImage;
    }

    public int getIntDummyWriter() {
        return intDummyWriter;
    }

    public void setIntDummyWriter(int intDummyWriter) {
        this.intDummyWriter = intDummyWriter;
    }

    public String getStrDummyTitle() {
        return strDummyTitle;
    }

    public void setStrDummyTitle(String strDummyTitle) {
        this.strDummyTitle = strDummyTitle;
    }

    public String getStrDummyScore() {
        return strDummyScore;
    }

    public void setStrDummyScore(String strDummyScore) {
        this.strDummyScore = strDummyScore;
    }


    public String getStrDummySubtitle() {
        return strDummySubtitle;
    }

    public void setStrDummySubtitle(String strDummySubtitle) {
        this.strDummySubtitle = strDummySubtitle;
    }
}