package com.lc.controller.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseTest {

//        static {
//            conf = HBaseConfiguration.create();
//            conf.set("hbase.master", "192.168.142.129:16000");
//            conf.set("hbase.zookeeper.quorum", "192.168.1.7");//必须有
//            conf.set("hbase.zookeeper.property.clientPort", "2181");//可有可无
//            conf.set("hbase.rootdir", "192.168.1.7:9001");//可有可无
//            //conf更多参数配置需要看详细看百度
//            System.out.println("连接创建完成!" + conf);
//         }

    public static Configuration conf;
    public static Connection connection;
    public static Admin admin;
    public static void main(String[] args) throws Exception {

        String tableName = "luffy_1107table01";
//
//        HTable table = new HTable(conf,tableName);
//
//        HbaseTest.createTable(tableName,"name");

        conf = HBaseConfiguration.create();
        conf.set("hbase.master", "192.168.1.7:16000");

        connection = ConnectionFactory.createConnection(conf);
        admin = connection.getAdmin();

        HTableDescriptor table = new HTableDescriptor(tableName.valueOf("table1"));
        table.addFamily(new HColumnDescriptor("group1")); //创建表时至少加入一个列组

        if(admin.tableExists(table.getTableName())){
            admin.disableTable(table.getTableName());
            admin.deleteTable(table.getTableName());
        }
        admin.createTable(table);
    }


        /**
       * 创建table:table name ：表名
       * @param tablename
       * @param columnFamily
       * @throws Exception
       */
        public static void createTable(String tablename, String columnFamily) throws Exception {
                //获取hbase管理
                HBaseAdmin admin = new HBaseAdmin(conf);
                //判断表是否存在
                if(admin.tableExists(tablename)) {
                System.out.println("Table exists!");
                System.exit(0);
                 }else {
                 //创建表
                HTableDescriptor tableDesc = new HTableDescriptor(tablename.valueOf(tablename));
                tableDesc.addFamily(new HColumnDescriptor(columnFamily));
                admin.createTable(tableDesc);
                System.out.println("create table success!");
                }
                //关闭
                admin.close();
                }
}
