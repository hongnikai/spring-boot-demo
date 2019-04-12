package com.lc.controller;

import com.lc.rss.Rss;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("testController")
@SuppressWarnings("all")
public class TestController {



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






}
