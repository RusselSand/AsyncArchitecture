package com.popug.demo.service;

import com.popug.demo.exception.DataNotFoundException;
import com.popug.demo.model.Data;
import com.popug.demo.model.DataDto;
import com.popug.demo.model.DataMapper;
import com.popug.demo.repo.DataRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService{
    private final DataRepo dataRepo;
    private final DataMapper dataMapper;

    public DataServiceImpl(DataRepo dataRepo, DataMapper dataMapper){
        this.dataRepo = dataRepo;
        this.dataMapper = dataMapper;
        loadTestData();
    }

    public DataDto getDataById(Integer id){
        Data result = dataRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found"));
        return dataMapper.toDto(result);
    }

    public List<DataDto> getAllData(){
        List<Data> result = dataRepo.findAll();
        return result.stream().map(dataMapper::toDto).collect(Collectors.toList());
    }

    public DataDto saveNewData(DataDto dto){
        Data result = dataRepo.save(dataMapper.toEntity(dto));
        return dataMapper.toDto(result);
    }

    public void loadTestData(){
        dataRepo.deleteAll();
        Data data1 = new Data(1, "test1");
        Data data2 = new Data(2, "test2");
        Data data3 = new Data(3, "test3");
        dataRepo.save(data1);
        dataRepo.save(data2);
        dataRepo.save(data3);
    }
}
