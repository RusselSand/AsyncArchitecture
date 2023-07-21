package com.popug.demo.service;

import com.popug.demo.model.DataDto;

import java.util.List;

public interface DataService {
    DataDto getDataById(Integer id);
    List<DataDto> getAllData();
    DataDto saveNewData(DataDto dto);
}
