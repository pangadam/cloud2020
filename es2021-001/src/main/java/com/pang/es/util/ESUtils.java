package com.pang.es.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;

public class ESUtils {

    /**
     * 创建索引
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    public static RestHighLevelClient createIndex(String indexName) throws Exception {
        RestHighLevelClient highLevelClient = null;
        try {
            // 创建链接
            highLevelClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost", 9200, "http"))
            );
            IndicesClient indices = highLevelClient.indices();

            // 创建索引
            if (!indices.exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT)) {
                CreateIndexResponse createIndexResponse = indices.create(new CreateIndexRequest(indexName), RequestOptions.DEFAULT);
                System.out.println("索引创建结果：" + createIndexResponse.isAcknowledged());
            }
            return highLevelClient;
        } catch (Exception e) {
            closeESConnection(highLevelClient);
            throw e;
        }
    }

    /**
     * 关闭ES连接
     *
     * @param highLevelClient
     * @throws Exception
     */
    public static void closeESConnection(RestHighLevelClient highLevelClient) throws Exception {
        if (highLevelClient == null) {
            return;
        }
        highLevelClient.close();
    }

}
