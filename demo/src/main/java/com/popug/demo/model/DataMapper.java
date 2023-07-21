package com.popug.demo.model;

import org.springframework.stereotype.Service;

@Service
public class DataMapper {
    public DataDto toDto(Data entity){
        return new DataDto(entity.getId(), entity.getName());
    }

    public Data toEntity(DataDto dto){
        return new Data(dto.getId(), dto.getName());
    }
}
