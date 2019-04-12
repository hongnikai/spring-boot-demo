package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Runnable  {

    public static void main(String[] args) {
        System.out.println(toThreadPool());
    }
    public synchronized static Object toThreadPool(){

        Vector vector = new Vector();
        vector.add("1");
        vector.add("3");
        vector.add("2");
        Vector<Map> vector1 = new Vector<Map>();
        Map map = new HashMap();
        map.put("key1","1");
        map.put("key2","2");
        vector1.add(map);
        vector1.addAll(vector);
        return vector1;
    }


}
