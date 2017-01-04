
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class TestKML1{
    public static void main(String args[]){
        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/定州市光缆.lyr.kml"), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String desc1 = "";
            String desc2 = "";
            while ((desc1 = br.readLine()) != null) {
                if (desc1.contains("<description>")) {
                    while (!br.readLine().contains("</description>")) {
                    }
                } else {
                    sb.append(desc1).append("\r\n ");
                }
                //sb.append(desc1).append("\r\n ");
            }
            br.close();
            //BufferedWriter newfile = new BufferedWriter(new FileWriter("D:/安国市光缆1.kml"));
            System.out.println(sb.toString());
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream("定州市光缆.lyr.kml"), "UTF-8");
            write.write(sb.toString());
            write.close();

           
        } catch (Exception ex) {
        }
    }
}
