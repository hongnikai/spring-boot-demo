package com.lc.controller.hadoop.hbase;


import com.lc.util.JavaLinux;

import org.apache.hadoop.hbase.client.*;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

@SuppressWarnings("all")
@RestController
@Scope(value="prototype")
@RequestMapping("/hbaseController")
public class HbaseController {

    public static Configuration configuration;
    public static Connection connection;
    public static Admin admin;


    @RequestMapping("/test")
    public Object test(
    ){
        return "结束";
    }


    public static void main(String[] args) {






    }
}
