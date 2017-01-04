
import model.Coordinates;
import model.KMLbean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LONG
 */
public class TestKML3 {

    public static void main(String args[]) {
        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        String filename = "D:/北市区光缆.lyr.kml";
        String desc1 = "";
        String desc2 = "";
        BufferedReader br;
        StringBuffer sb = new StringBuffer();
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
            //data d = new data("D:/安国市光缆1.kml");
            sb = new StringBuffer();
            desc1 = "";
            desc2 = "";
            ArrayList<KMLbean> list = new ArrayList();
            ArrayList<KMLbean> list1 = new ArrayList();
            int count = -1;//#1 作为测试用途，无实际意义！
            while ((desc1 = br.readLine()) != null) {
                if (desc1.contains("<description>")) {
                    while (!br.readLine().contains("</description>")) {
                    }
                }
                if (desc1.contains("<Placemark")) {
                    //count++;//#1 作为测试用途，无实际意义！
                    KMLbean kml = new KMLbean();
                    String id = desc1.replace("<Placemark id=\"", "").replace("\">", "");
                    kml.setId(id.trim());
                    ArrayList a = new ArrayList();
                    while (!(desc2 = br.readLine()).contains("</Placemark>")) {
                        
                        a = kml.getCoordinates();
                        if (desc2.contains("<name")) {
                            String name = desc2.replace("<name>", "").replace("</name>", "");
                            kml.setName(name.trim());
                        }
                        if (desc2.contains("<coordinates>")) {
                            //count++;//#1 作为测试用途，无实际意义！
                            ArrayList b = new ArrayList();
                            String[] tmp = br.readLine().trim().replace("\t", "").split(" ");
//                            for(int i=0;i<tmp.length;i++){
//                                System.out.println(tmp[i]);
//                            }
//System.out.println( tmp.length);2# 作为测试用途，无实际意义！
                            for (int i = 0; i < tmp.length; i++) {
                                String[] tmp1 = tmp[i].trim().split(",");
                                Coordinates c = new Coordinates();
                                c.setLat(tmp1[0]);
                                c.setLnt(tmp1[1]);
                                //System.out.println(c);
                                b.add(c);
                            }
                            a.add(b);
                        }
                    }
                    kml.setCoordinates(a);
//System.out.println( a.size());//2# 作为测试用途，无实际意义！
                    list.add(kml);
//System.out.println("-------");2# 作为测试用途，无实际意义！
                }
                if (desc1.contains("<Folder") || desc1.contains("</Folder")) {
                }
            }
//            //=======遍历list 找出相同的名称的线路段落来======= 
//            for (int i = 0; i < list.size(); i++) {
//                KMLbean tmpKML = new KMLbean();
//                KMLbean iteratorKML = new KMLbean();
//                tmpKML = list.get(i);
//                String name = tmpKML.getName();
//                Iterator<KMLbean> iterator = list.iterator();
//                while (iterator.hasNext()) {
//                    iteratorKML = iterator.next();
//                    if (tmpKML.getName().equals(iteratorKML.getName()) && !tmpKML.getId().equals(iteratorKML.getId())) {
////                        System.out.println(tmpKML.getName()+"---"+iteratorKML.getName());
////                        System.out.println(tmpKML.getCoordinates()+"\t\n"+iteratorKML.getCoordinates());
//                        ArrayList a = new ArrayList();
//                        a = tmpKML.getCoordinates();
//                        for (int k = 0; k < iteratorKML.getCoordinates().size(); k++) {
//                            ArrayList tmpArray = new ArrayList();
//                            tmpArray = (ArrayList) iteratorKML.getCoordinates().get(k);
//                            a.add(tmpArray);
//                        }
//                        tmpKML.setCoordinates(a);
//                        iterator.remove();
//                    }
//                }
//                list1.add(tmpKML);
//            }
//            //System.out.println(list1.get(1111).getCoordinates().size());
//            //**需要把每一个KMLbean中的coordinates线段排序下面是排序算法：
//            {
//                for (int i = 0; i < list1.size(); i++) {
//                    //System.out.println(list1.size());
//                    ArrayList a = new ArrayList();//存放排序后的coordinates
//                    ArrayList tmp = new ArrayList();//临时
//                    //--------------------------------------------开始对每一个KMLbean内的LineString段排序
//                    tmp = list1.get(i).getCoordinates();
//                    a.add(tmp.get(0));//将一组主干路由的一段放入集合（一段内有若干个经纬度组成）
//                    Iterator<ArrayList> iterator = tmp.iterator();
//                    while (iterator.hasNext()) {
//                        //System.out.println(a.size());
//                        ArrayList ccc = iterator.next();
//                        ArrayList front = new ArrayList();//存放a的第一个直线的
//                        ArrayList rear = new ArrayList(); //存放a的最后一个直线的
//                        front = (ArrayList) a.get(0);
//                        rear = (ArrayList) a.get(a.size() - 1);
//                        //System.out.println(front.size()+"--"+rear.size());
//                        Coordinates front_f = (Coordinates) front.get(0);
//                        Coordinates front_r = (Coordinates) front.get(front.size() - 1);
//                        
//                        Coordinates rear_f = (Coordinates) rear.get(0);
//                        Coordinates rear_r = (Coordinates) rear.get(rear.size() - 1);
////System.out.println(((ArrayList) ccc).size());
//                        Coordinates now_f = (Coordinates) ((ArrayList) ccc).get(0);
//                        //Coordinates now_r = (Coordinates) (tmpList).get(ccc.size() - 1);
//                        Coordinates now_r = (Coordinates) ((ArrayList) ccc).get(ccc.size() - 1);
//                        //*******************************************************************************
//                        //-------------------------------排序核心算法(开始)------------------------------
//                        //*******************************************************************************
////                        System.out.println(now_f.getLat()+"---"+front_f.getLat());
////                        System.out.println(now_f.getLnt()+"---"+front_f.getLnt());
//                        if (now_f.getLat().equals(front_f.getLat()) && now_f.getLnt().equals(front_f.getLnt())) {
//                            ArrayList aaa = new ArrayList();
//                            ArrayList bbb = (ArrayList) ccc;
//                            for (int h = bbb.size() - 1; h > 0; h--) {
//                                aaa.add((Coordinates) ((ArrayList) ccc).get(h));
//                            }
//                            a.add(0, aaa);
//                            iterator.remove();
//                            //System.out.println(a);
//                        } else if (now_f.getLat().equals(front_r.getLat()) && now_f.getLnt().equals(front_r.getLnt())) {
//                            a.add(ccc);
//                            iterator.remove();
//                        } else if (now_f.getLat().equals(rear_r.getLat()) && now_f.getLnt().equals(rear_r.getLnt())) {
//                            a.add(ccc);
//                            iterator.remove();
//                        } else if (now_r.getLat().equals(front_f.getLat()) && now_r.getLnt().equals(front_f.getLnt())) {
//                            a.add(0, ccc);
//                            iterator.remove();
//                        } else if (now_r.getLat().equals(rear_r.getLat()) && now_r.getLnt().equals(rear_r.getLnt())) {
//                            ArrayList aaa = new ArrayList();
//                            ArrayList bbb = (ArrayList) ccc;
//                            for (int h = bbb.size() - 1; h > 0; h--) {
//                                aaa.add((Coordinates) ((ArrayList) ccc).get(h));
//                            }
//                            a.add(0, aaa);
//                            iterator.remove();
//                        } else {
////                            System.out.println("--------------");
////                            System.out.println(now_f.getLat() + "," + now_f.getLnt());
////                            System.out.println("--------------");
////                            System.out.println(front_r.getLat() + "," + front_r.getLnt());
////                            System.out.println(front_f.getLat() + "," + front_f.getLnt());
////                            System.out.println(rear_r.getLat() + "," + rear_r.getLnt());
////                            System.out.println(rear_f.getLat() + "," + rear_f.getLnt());
////                            a.add(ccc);
//                        }
//                        front_f = null;
//                        front_r = null;
//                        front = null;
//                        rear_f = null;
//                        rear_r = null;
//                        System.out.println(tmp.size());
//                    }
//                    list1.get(i).setCoordinates(a);
//                    tmp = null;
//                    a = null;
//                    //System.out.println(a);
//                }
//            }

            //OutputStreamWriter write1 = new OutputStreamWriter(new FileOutputStream("filename"), "UTF-8");
            //System.out.println(list1.toString().replace("\t", ""));
            //System.out.println(count);
            System.out.println(sb.toString().replace("</Document>", "").replace("</kml>", "") + list.toString().replace("\t", "").replace("[", "").replace("]", "") + "</Document>\t\n</kml>");
//            write1.write(sb.toString().replace("</Document>", "").replace("</kml>", "") + list1.toString().replace("\t", "").replace("[", "").replace("]", "") + "</Document>\t\n</kml>");
//            write1.flush();
//            write1.close();
            br = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
