package com.example.Gaur.service;


import com.example.Gaur.entity.JobSheet;

import java.util.List;

public interface JobSheetService {
    JobSheet AddJobSheet(JobSheet sheet);
  List<  JobSheet > getAllJobs();

    JobSheet getById( Integer clientId);
    
    void deleteById(Integer clientId);

    JobSheet updateJobSheet(Integer clientId,JobSheet job);
  //  JobSheetDto updateJobSheet(JobSheetDto dto);
}
