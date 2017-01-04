
import model.KMLbean;
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
public class TestKML2 {

    public static void main(String args[]) {
        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        String desc1 = "";
        String desc2 = "";
        BufferedReader br;
        StringBuffer sb = new StringBuffer();
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/定州市光缆.lyr.kml"), "UTF-8"));
            //data d = new data("D:/安国市光缆1.kml");
            sb = new StringBuffer();
            desc1 = "";
            desc2 = "";
            ArrayList<KMLbean> list = new ArrayList();
            ArrayList<KMLbean> list1 = new ArrayList() {
                public String toString() {
                    String tmp = "";
                    for (int i = 0; i < this.size(); i++) {
                        tmp = tmp + this.get(i).toString();
                    }
                    return tmp;
                }
            };
            while ((desc1 = br.readLine()) != null) {
                if (desc1.contains("<Placemark")) {
                    KMLbean kml = new KMLbean();
                    String id = desc1.replace("<Placemark id=\"", "").replace("\">", "");
                    kml.setId(id.trim());
                    while (!(desc2 = br.readLine()).contains("</Placemark>")) {
                        if (desc2.contains("<name")) {
                            String name = desc2.replace("<name>", "").replace("</name>", "");
                            kml.setName(name.trim());
                        }
                        if (desc2.contains("<coordinates>")) {
                            ArrayList a = new ArrayList();
                            a = kml.getCoordinates();
                            a.add(br.readLine().trim());
                            kml.setCoordinates(a);
                        }
                    }
                    list.add(kml);
                } else if (desc1.contains("<Folder")) {
//                    while (!(desc2 = br.readLine()).contains("</Folder>")) {
//                    }
//                    br.readLine();
                } else {
                    sb.append(desc1).append("\r\n ");
                }
                //sb.append(desc1).append("\r\n ");
            }
            //=======遍历list 找出相同的名称点来======= 
            for (int i = 0; i < list.size(); i++) {
                KMLbean tmpKML = new KMLbean();
                tmpKML = list.get(i);
                String name = tmpKML.getName();
                for (int j = i + 1; j < list.size(); j++) {
                    if (tmpKML.getName().equals(list.get(j).getName())) {
                        ArrayList a = new ArrayList();
                        a = tmpKML.getCoordinates();
                        list.get(j).getCoordinates();
                        for(int k=0;k<list.get(j).getCoordinates().size();k++){
                            a.add(list.get(j).getCoordinates().get(k));
                        }  
                        tmpKML.setCoordinates(a);
                        list.remove(j);
                        --j;
                    }
                }
                list1.add(tmpKML);
                tmpKML = null;
            }
            //OutputStreamWriter write1 = new OutputStreamWriter(new FileOutputStream("D:/定州市光缆.lyr.kml"), "UTF-8");
            System.out.println(list1.toString().replace("\t", ""));
            //System.out.println(sb.toString().replace("</Document>", "").replace("</kml>","")+list1.toString().replace("\t", "").replace("[","").replace("]","")+"</Document>\t\n</kml>");
            //write1.write(sb.toString().replace("</Document>", "").replace("</kml>","")+list1.toString().replace("\t", "").replace("[","").replace("]","")+"</Document>\t\n</kml>");
            //write1.flush();
            //write1.close();
            br=null;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
