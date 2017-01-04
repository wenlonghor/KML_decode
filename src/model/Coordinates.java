package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LONG
 */
public class Coordinates {
    private String lat=null;
    private String lnt=null;
    private String Z="0 ";

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public String getZ() {
        return Z;
    }

    public void setZ(String Z) {
        this.Z = Z;
    }

//    @Override
//    public String toString() {
//        String tmp="";
//        tmp=lat+","+lnt+","+"0 ";
//        return tmp; //To change body of generated methods, choose Tools | Templates.
//    }
//    
}
