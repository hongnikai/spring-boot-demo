package com.lc.rss;

import java.util.*;

@SuppressWarnings("all")
public class RssAnalysis {

    public static List<Map<String,String>> getRssAnalysis(String data){

        Map<String,String> map =new HashMap<String, String>();
        List<Map<String,String>> list =  new ArrayList<Map<String,String>>();
        String[] str=data.split("<item>");
        for (int i=1;i<str.length;i++){
            String title = null;
            String link = null;
            String description = null;
            String guid = null;
            String creator = null;
            String item_spilt=str[i];
            try {
//                System.out.println(item_spilt);
                title = item_spilt.split("<title>")[1].split("</title>")[0];
                 link = item_spilt.split("<link>")[1].split("</link>")[0];
                 description = item_spilt.split("<description>")[1].split("</description>")[0];
                 guid = item_spilt.split("<guid")[1].split("</guid>")[0].split(">")[1];
                 creator = item_spilt.split("<dc:creator>")[1].split("</dc:creator>")[0];
            }catch (Exception e){
                System.out.println("标签不存在");
            }
            System.out.println(creator);
            map.put("title",title);
            map.put("link",link);
            map.put("description",description);
            map.put("guid",guid);
            map.put("creator",creator);
            list.add(map);

            Iterator entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String key = (String)entry.getKey();
                String value = (String) entry.getValue();
                System.out.println("Key = " + key + ", Value = " + value);
            }
        }

        return list;
    }




}
