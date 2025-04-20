package com.homework.springBoot.controller;

import com.homework.springBoot.model.Television;
import com.homework.springBoot.service.TelevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/author")

public class TelevisionController {
    @Autowired
    private TelevisionService televisionService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Television> getTelevision (@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(televisionService.getTelevisionById(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Television>> listTelevision() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(televisionService.findAll());
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Television> create(@RequestBody Television newTelevision) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(televisionService.save(newTelevision));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Television> update (@RequestBody Television newInfo, @RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(televisionService.update(newInfo, id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable(value = "id") Long id) {
        televisionService.deleteById(id);
}}
