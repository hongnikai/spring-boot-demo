package com.lc.controller;

import com.lc.rss.Rss;
import com.lc.service.OracleService;
import com.lc.service.UserService;
import com.lc.service.UserinfoService;
import com.lc.util.SizeofUtil;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import net.sourceforge.sizeof.SizeOf;
import sun.misc.Unsafe;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("testController")
@SuppressWarnings("all")
public class TestController {

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private OracleService oracleService;

        @RequestMapping("/RssTest")
        public String RssTest() throws IOException, FeedException {

//            String url = "http://news.qq.com/newsgn/rss_newsgn.xml";
//            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
//            System.out.println(feed.getTitle());
//            System.out.println(feed.getEntries());
//            for (int j=0;j<feed.getEntries().getClass().getName().length();j++){
//                String str = feed.getEntries().getClass().getName();
//                System.out.println(feed.getEntries().getClass().getName());
//
//
//            }

//            List list = feed.getEntries();
//
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
//            }

            Rss rss =new Rss();
            String url = "http://news.qq.com/newsgn/rss_newsgn.xml";
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
            rss.parseXml(new URL(url));

            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            String string= syndFeedOutput.outputString(feed);

//        RssAnalysis.getRssAnalysis(string);

            System.out.println(string);

            return feed.getTitle();

        }


        @RequestMapping("/RestTest2")
        public void RestTest2() throws FeedException {

            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType("rss_2.0");
            feed.setTitle("test-title");
            feed.setDescription("test-description");
//            feed.setLink("http://news.qq.com/newsgn/rss_newsgn.xml");
            feed.setLink("http://news.qq.com/newsgn/rss_newsgn.xml");

//            System.out.println(new SyndFeedOutput().outputString(feed));
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
           String string= syndFeedOutput.outputString(feed);
            System.out.println(string);

        }

//    @RequestMapping("/insertTeamData")
//    public Object insertTeamData()throws Exception{
////            Map map =new HashMap();
////            map.put("id","1");
////            map.put("name","小红");
////            Map map2 =new HashMap();
////            map2.put("id","2");
////            map2.put("name","小黄");
////            Map map3 =new HashMap();
////            map3.put("id","3");
////            map3.put("name","小绿");
//        List list = new ArrayList();
//        for(int i=0;i<20000;i++){
//            Map map = new HashMap();
//            map.put("id",i+" ");
//            map.put("name","第"+i+"个人");
//            list.add(map);
//        }
//        System.out.println(SizeofUtil.sizeof(list));
//            userService.insertUsers(list);
//            return list;
//        }


//    public static void main(String[] args) throws Exception {
//        TestController testController = new TestController();
//        testController.insertTeamData();
//    }

//    @RequestMapping("/oracleTest")
//    public Object oracleTest(){
//            List list = oracleService.selectTest();
//            return list;
//    }
//
//    @RequestMapping("/returnJson")
//    public Object returnJson(){
//
//            Map map = new HashMap();
//            map.put("name","zhangsan");
//            List<Map<String,Object>>  list = userService.selectAllUser();
//            if(list.size()>0){
//
//                System.out.println("ceshi");
//
//            }
//        System.out.println(list.size());
//        System.out.println(list!=null);
//            return map;
//    }

    @Autowired
    private UserinfoService userinfoService;


    @RequestMapping("/test")
    public Object test(){
        return userinfoService.deleteUser(0);
    }

    @RequestMapping("/testData")
    public String testData(){


        return "sssss";
    }

}
