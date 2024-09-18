package com.example.Gaur.impl;


import com.example.Gaur.entity.JobSheet;
import com.example.Gaur.exception.ResourceNotFoundException;
import com.example.Gaur.repository.JobSheetRepo;
import com.example.Gaur.service.JobSheetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobSheetServiceImpl implements JobSheetService {

    @Autowired
    private JobSheetRepo repo;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper;
    @Override
    public JobSheet AddJobSheet(JobSheet sheet) {

        JobSheet save= repo.save(sheet);

        return (save);
    }

    @Override
    public List<JobSheet> getAllJobs() {
       List<JobSheet>j =repo.findAll();

        return j.stream().collect(Collectors.toList());
    }

    @Override
    public JobSheet getById(Integer clientId) {
      JobSheet j1 =  repo.findById(clientId).orElseThrow(() ->
                new ResourceNotFoundException("record not exist with given id"+ clientId));

        return j1;
    }

    @Override
    public void deleteById(Integer clientId) {
      JobSheet sheet = repo.findById(clientId).orElseThrow(()->
              new ResourceNotFoundException("record not exist with given id :: "+clientId));
      if (sheet!=null)
      repo.delete(sheet);

    }

    @Override
    public JobSheet updateJobSheet(Integer clientId, JobSheet job) {
       JobSheet client = repo.findById(clientId).orElseThrow(()->
                new ResourceNotFoundException("record not exist with id :: "+clientId));
        client.setClientName(job.getClientName());
        client.setContact(job.getContact());
        client.setClientNote(job.getClientNote());
        client.setDeadline(job.getDeadline());
        client.setStatus(job.getStatus());
        client.setAssignedTechnician(job.getAssignedTechnician());
        client.setEstimateAmount(job.getEstimateAmount());
        client.setReceivedDate(job.getReceivedDate());
        client.setReceivedInventory(job.isReceivedInventory());
        client.setUploadInventory(job.getUploadInventory());
        client.setReportedIssue(job.getReportedIssue());

       JobSheet updatedClient = repo.save(client);
        return updatedClient;
    }

/*
    public JobSheet mapToJobSheetDto(JobSheetDto dto){
        JobSheet sheet;
        sheet = this.modelMapper.map(dto,JobSheet.class);
        return sheet;
    }
    public JobSheetDto mapToJobSheet(JobSheet sheet){
        JobSheetDto dto = this.modelMapper.map(sheet,JobSheetDto.class);
        return dto;
    }

 */




   // @Override
  //  public JobSheetDto updateJobSheet(JobSheetDto dto) {
      //  JobSheetDto find=repo.findById(dto.getClientId());
        
       // return null;
   // }
}
