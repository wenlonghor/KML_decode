/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author LONG
 */
public class DEL_description {

    String filename;
    FileOutputStream out = null;
    FileOutputStream outSTr = null;
    BufferedOutputStream Buff = null;

    public DEL_description(String filename) {
        this.filename = filename;
    }

    public boolean doit() {
        try {
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
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
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
            write.write(sb.toString());
            write.close();

        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
