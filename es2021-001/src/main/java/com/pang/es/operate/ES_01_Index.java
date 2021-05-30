package com.pang.es.operate;

import com.pang.es.util.ESUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * ES连接以及索引创建
 */
public class ES_01_Index {

    public static void main(String[] args) throws Exception {

        RestHighLevelClient highLevelClient = ESUtils.createIndex("es-test");

        try {
            // 获取索引信息
            GetIndexResponse getIndexResponse = highLevelClient.indices().get(new GetIndexRequest("es-test"), RequestOptions.DEFAULT);
            System.out.println(getIndexResponse.getSettings());
            System.out.println(getIndexResponse.getMappings());
            System.out.println(getIndexResponse.getAliases());

            // 删除索引
            AcknowledgedResponse acknowledgedResponse = highLevelClient.indices().delete(new DeleteIndexRequest("es-test"), RequestOptions.DEFAULT);
            System.out.println("删除结果：" + acknowledgedResponse.isAcknowledged());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ESUtils.closeESConnection(highLevelClient);
        }
    }

}
