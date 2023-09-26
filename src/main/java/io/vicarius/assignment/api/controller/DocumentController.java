package io.vicarius.assignment.api.controller;

import io.vicarius.assignment.api.entity.Document;
import io.vicarius.assignment.api.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author poliakoveliezer Product Controller
 */
@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    /**
     * Create a document
     *
     * @param document to save
     */
    @PostMapping
    public @ResponseBody ResponseEntity<String> createDocument(@RequestBody Document document) {
        return ResponseEntity.status(HttpStatus.OK).body(documentService.createDocument(document));
    }

    /**
     * Find a document
     *
     * @param index to search
     */
    @GetMapping
    public @ResponseBody ResponseEntity<Document> findDocument(@RequestParam("index") String index) {
        return ResponseEntity.status(HttpStatus.OK).body(documentService.findDocument(index));
    }
}
