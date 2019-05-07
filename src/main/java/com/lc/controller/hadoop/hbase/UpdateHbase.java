package com.lc.controller.hadoop.hbase;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.lc.util.TimeUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.hibernate.mapping.Map;

@SuppressWarnings("ALL")
public class UpdateHbase {

    private HBaseAdmin admin = null;
    private Configuration conf = null;

    public UpdateHbase() throws Exception
    {
        conf = HBaseConfiguration.create();
        System.setProperty("hadoop.home.dir", "http://192.168.56.1/server/hadoop/hadoop-2.7.2");
        conf.addResource(new Path("/sever/hbase/hbase-1.4.9/conf/hbase-site.xml"));
        conf.set("hbase.zookeeper.quorum", "192.168.56.1");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        admin = new HBaseAdmin(conf);
    }

    public void createTable (String tableName , String[] columnFamily) throws Exception
    {
        if (admin.tableExists(tableName))
        {
            System.out.println(tableName + "已存在");
            return ;
            //System.exit(0);
        }

        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

        for (String colunm : columnFamily)
        {
            tableDescriptor.addFamily(new HColumnDescriptor(colunm));
        }

        admin.createTable(tableDescriptor);
        System.out.println("Create table successfully..");
    }

    public boolean deleteTable (String tableName)
    {
        try {
            if(admin.tableExists(tableName))
            {
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
                System.out.println("drop table " + tableName);
            }
            return true;
        } catch (Exception e) {
            System.out.println("删除" + tableName + "失败");
            return false;
        }
    }

    public List getAllTables()
    {
        List<String> tables = null;
        if (admin != null)
        {
            try{
                HTableDescriptor[] allTables = admin.listTables();
                if(allTables.length > 0)
                {
                    tables = new ArrayList<String>();
                }

                for (HTableDescriptor tableDesc : allTables)
                {
                    tables.add(tableDesc.getNameAsString());
                    System.out.println(tableDesc.getNameAsString());
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

        return tables;
    }

    public boolean addOneRecord (String tableName , String key , String family , String column
            , byte[] dataIn) throws Exception
    {
        HConnection connection = HConnectionManager.createConnection(conf);
        //HTable table = new HTable(hbaseConf, tableName);
        HTable table = (HTable)connection.getTable(tableName);
        Put put = new Put(key.getBytes());
        put.add(family.getBytes(), column.getBytes(), dataIn);
        try {
            table.put(put);
            System.out.println("插入数据条 " + key + "成功");
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("插入数据条 " + key + "失败");
            return false;
        }
    }

    public void getValueFromKey (String tableName , String key)
    {
        try{
            HConnection conn = HConnectionManager.createConnection(conf);
            HTable table = (HTable) conn.getTable(tableName);
            Get get = new Get(key.getBytes());
            Result rs = table.get(get);
            if (rs.rawCells().length == 0)
            {
                System.out.println("不存在关键字为" + key + "的行...");
            }
            else
            {
                for (Cell cell : rs.rawCells())
                {
                    System.out.println(new String(CellUtil.cloneFamily(cell)) +
                            "  " + new String(CellUtil.cloneQualifier(cell)) + "  " + new String(CellUtil.cloneValue(cell)));
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("查询失败");
            ex.printStackTrace();
        }
    }



    public void getAllData(String tableName) throws Exception
    {
        HConnection conn = HConnectionManager.createConnection(conf);
        HTable table = (HTable) conn.getTable(tableName);
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        for (Result result : rs)
        {
            for (Cell cell : result.rawCells())
            {
                System.out.println("RowName: " + new String(CellUtil.cloneRow(cell)) + " ");
                System.out.println("Timetamp: " + TimeUtil.getStringByTimeStamp(cell.getTimestamp())+ " ");
                System.out.println("Column family: " + new String(CellUtil.cloneFamily(cell)) + " ");
                System.out.println("row name: " + new String(CellUtil.cloneQualifier(cell)) + " ");
                System.out.println("value: " + new String(CellUtil.cloneValue(cell)) + " ");
            }
        }
    }

    public void deleteRecord(String tableName , String key)
    {
        try
        {
            HConnection conn = HConnectionManager.createConnection(conf);
            HTable table = (HTable)conn.getTable(tableName);
            Delete delete = new Delete(key.getBytes());

            table.delete(delete);
            System.out.println("删除" + key +"成功...");
        }
        catch(Exception ex)
        {
            System.out.println("删除数据失败...");
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        String[] column = {"family1" , "family2"};

        try {
            UpdateHbase hbase = new UpdateHbase();
//            hbase.deleteTable("students");
//             hbase.createTable("students", column);
//           hbase.getAllData("scores");
//           hbase.addOneRecord("students", "id1", "family1", "name", "Jack".getBytes());
           hbase.addOneRecord("students", "id1", "family1", "grade", "lc".getBytes());
//           hbase.getAllTables();
            hbase.getAllData("students");

            //删除节点
//            hbase.getValueFromKey("students", "id1");
//            hbase.deleteRecord("students", "id1");
//            hbase.addOneRecord("students", "id2", "family1", "name", "Holen".getBytes());
//            hbase.getValueFromKey("students", "id2");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }



    }

}
