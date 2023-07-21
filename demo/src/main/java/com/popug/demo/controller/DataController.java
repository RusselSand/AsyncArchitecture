package com.popug.demo.controller;

import com.popug.demo.model.DataDto;
import com.popug.demo.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;
    public DataController(DataService dataService){
        this.dataService = dataService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<DataDto>> getAll(){
        return new ResponseEntity<>(dataService.getAllData(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DataDto> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(dataService.getDataById(id), HttpStatus.OK);
    }
}
