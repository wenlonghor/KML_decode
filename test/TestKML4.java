
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LONG
 */
public class TestKML4 {

    public static void main(String args[]) {
        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        String desc1 = "";
        String desc2 = "";
        BufferedReader br;
        StringBuffer sb = new StringBuffer();
        String name="D:/北市区光缆.lyr.kml";
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(name), "UTF-8"));//读取KML文件
            sb = new StringBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
