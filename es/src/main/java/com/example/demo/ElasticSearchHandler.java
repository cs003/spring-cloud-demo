package com.example.demo;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;


/**
 * Created by jiaozhiguang on 2017/8/12.
 */
public class ElasticSearchHandler {
    public static void main(String[] args) {
        try {
            /* 创建客户端 */
            // client startup
//            Client client = TransportClient.builder().build()
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

//            Settings settings = Settings.builder()
//                    .put("cluster.name", "zhiguangkeji").build();
//                            put("client.transport.sniff", true).build();
//
//            TransportClient client = new PreBuiltTransportClient(settings);

            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("17.0.0.1"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));


            List<String> jsonData = DataFactory.getInitJsonData();

            for (int i = 0; i < jsonData.size(); i++) {
                IndexResponse response = client.prepareIndex("blog", "article").setSource(jsonData.get(i)).get();
                if (response.isCreated()) {
                    System.out.println("创建成功!");
                }
            }
            client.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }
}
