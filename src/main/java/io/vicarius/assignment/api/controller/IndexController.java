package io.vicarius.assignment.api.controller;

import io.vicarius.assignment.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author poliakoveliezer Product Controller
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IndexService indexService;

    /**
     * Create an index
     */
    @PostMapping
    public @ResponseBody ResponseEntity<Boolean> createIndex() {
        return ResponseEntity.status(HttpStatus.OK).body(indexService.createIndex());
    }
}
