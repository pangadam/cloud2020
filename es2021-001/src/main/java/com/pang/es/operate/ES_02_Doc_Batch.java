package com.pang.es.operate;

import com.pang.es.util.ESUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

public class ES_02_Doc_Batch {

    public static void main(String[] args) throws Exception {

        RestHighLevelClient highLevelClient = ESUtils.createIndex("account");

        try {
            // 批量新增
            BulkRequest indexBulkRequest = new BulkRequest();

            indexBulkRequest.add(new IndexRequest().index("account").id("2001").source("username", "hik vision1"));
            indexBulkRequest.add(new IndexRequest().index("account").id("2002").source("username", "hik vision2"));
            indexBulkRequest.add(new IndexRequest().index("account").id("2003").source("username", "hik vision3"));
            indexBulkRequest.add(new IndexRequest().index("account").id("2004").source("username", "hik vision4"));
            indexBulkRequest.add(new IndexRequest().index("account").id("2005").source("username", "hik vision5"));

            BulkResponse bulkResponse = highLevelClient.bulk(indexBulkRequest, RequestOptions.DEFAULT);
            System.out.println("耗时：" + bulkResponse.getTook());
            System.out.println(bulkResponse.getItems());

            // 批量删除
            BulkRequest deleteBulkRequest = new BulkRequest();
            deleteBulkRequest.add(new DeleteRequest().index("account").id("2001"));
            deleteBulkRequest.add(new DeleteRequest().index("account").id("2002"));
            deleteBulkRequest.add(new DeleteRequest().index("account").id("2003"));
            deleteBulkRequest.add(new DeleteRequest().index("account").id("2004"));
            deleteBulkRequest.add(new DeleteRequest().index("account").id("2005"));
            BulkResponse bulkResponse1 = highLevelClient.bulk(deleteBulkRequest, RequestOptions.DEFAULT);
            System.out.println("耗时：" + bulkResponse1.getTook());
            System.out.println(bulkResponse1.getItems());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ESUtils.closeESConnection(highLevelClient);
        }
    }

}
