package io.vicarius.assignment.api.service;

import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import io.vicarius.assignment.api.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author poliakoveliezer Product Service
 */
@Service
public class DocumentService {

    @Autowired
    IndexService indexService;

    /**
     * create document with index
     *
     * @param document document to save
     * @return id of document
     */
    public String createDocument(Document document) {
        try {
            IndexResponse response = indexService.esClient.index(i -> i.index("documents").id(document.getId()).document(document));
            return response.id();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * find document by index
     *
     * @param index for search
     */
    public Document findDocument(String index) {
        GetResponse<Document> response = null;
        try {
            response = indexService.esClient.get(g -> g.index("documents").id(index), Document.class);
            if (response.found()) return response.source();
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
