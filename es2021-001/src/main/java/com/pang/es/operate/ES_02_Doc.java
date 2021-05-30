package com.pang.es.operate;

import cn.hutool.json.JSONUtil;
import com.pang.es.domain.Account;
import com.pang.es.util.ESUtils;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ES_02_Doc {

    public static void main(String[] args) throws Exception {

        RestHighLevelClient highLevelClient = ESUtils.createIndex("account");

        try {
            // 创建数据
            Account account = new Account();
            account.setUsername("pang adam");
            account.setPassword("qazwsx 123");
            account.setAge(10);
            account.setAddress("湖北省武汉市洪山区关东街道曙光星城B区");

            // 新增doc或者全量更新
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index("account").id("1001").source(JSONUtil.toJsonStr(account), XContentType.JSON);
            IndexResponse indexResponse = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("新增或者全量更新结果：" + indexResponse.getResult());

            // 局部更新
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index("account").id("1001").doc("address", "湖北省武汉市洪山区关东街道曙光星城B区一栋一单元2318", "age", 40);
            UpdateResponse updateResponse = highLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            System.out.println("局部更新结果：" + updateResponse.getResult());

            // 查询数据
            GetResponse getResponse = highLevelClient.get(new GetRequest().index("account").id("1001"), RequestOptions.DEFAULT);
            System.out.println("查询结果：" + getResponse.getSourceAsString());

            // 删除
            DeleteResponse deleteResponse = highLevelClient.delete(new DeleteRequest().index("account").id("1001"), RequestOptions.DEFAULT);
            System.out.println("删除结果：" + deleteResponse.getResult());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ESUtils.closeESConnection(highLevelClient);
        }
    }

}
