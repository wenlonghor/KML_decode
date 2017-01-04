package model;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LONG
 */
public class KMLbean {

    private String id;
    private String name;
    private String Snippet;
    private ArrayList<ArrayList> coordinates = new ArrayList();

    @Override
    public String toString() {
        String tmp1 = "<Placemark id=\"" + id + "\">\r\n"
                + "<name>" + name + "</name>\r\n"
                + "<Snippet maxLines=\"0\"></Snippet>\r\n"
                + "<styleUrl>#LineStyle001</styleUrl>\r\n"
                + "<MultiGeometry>\r\n"
                + "<LineString>\t\n";
        String tmp3
                ="</LineString>\t\n"
                + "</MultiGeometry>\r\n"
                + "</Placemark>\r\n";
        String tmp2 = "";
        for (int i = 0; i < coordinates.size(); i++) {
             tmp2="<coordinates>\t\n";
            for(int j=0;j<coordinates.get(i).size();j++){
                tmp2=tmp2+((Coordinates)coordinates.get(i).get(j)).getLat()+","
                        +((Coordinates)coordinates.get(i).get(j)).getLnt()+",0 ";
            }
            tmp2=tmp2+"\t\n";
            tmp2=tmp2+"</coordinates>\t\n";
        }

        return (tmp1 + tmp2 + tmp3).trim();
    }
//    @Override
//    public String toString() {
//        String tmp1 = "<Placemark id=\"" + id + "\">\r\n"
//                + "<name>" + name + "</name>\r\n"
//                + "<Snippet maxLines=\"0\"></Snippet>\r\n"
//                + "<styleUrl>#LineStyle001</styleUrl>\r\n"
//                + "<MultiGeometry>\r\n"
//                + "<LineString>\t\n"
//                + "<coordinates>\t\n";
//        String tmp3
//                ="</coordinates>\t\n"
//                +"</LineString>\t\n"
//                + "</MultiGeometry>\r\n"
//                + "</Placemark>\r\n";
//        String tmp2 = "";
//        for (int i = 0; i < coordinates.size(); i++) {
//            for(int j=0;j<coordinates.get(i).size();j++){
//                tmp2=tmp2+((Coordinates)coordinates.get(i).get(j)).getLat()+","
//                        +((Coordinates)coordinates.get(i).get(j)).getLnt()+",0 ";
//            }
//        }
//        tmp2 = tmp2+"\t\n";
//        return tmp1 + tmp2 + tmp3;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnippet() {
        return Snippet;
    }

    public void setSnippet(String Snippet) {
        this.Snippet = Snippet;
    }

    public ArrayList getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList coordinates) {
        this.coordinates = coordinates;
    }

}
