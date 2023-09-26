package io.vicarius.assignment.api.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author poliakoveliezer Product Service
 */
@Service
public class IndexService {


    String serverUrl = "https://localhost:9300";
    String apiKey = "Q5YnN7-KUmlvoKMDM1Ni";

    RestClient restClient = RestClient.builder(HttpHost.create(serverUrl)).setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "ApiKey " + apiKey)}).build();

    ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

    ElasticsearchClient esClient = new ElasticsearchClient(transport);
    /**
     * create index
     */
    public boolean createIndex() {
        try {
            esClient.indices().create(c -> c.index("documents"));
            return true;
        } catch (IOException e) {
            return false;
        }
    }


}
