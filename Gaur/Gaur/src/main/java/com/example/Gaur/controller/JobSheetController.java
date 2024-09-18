package com.example.Gaur.controller;


import com.example.Gaur.entity.JobSheet;
import com.example.Gaur.service.JobSheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/jobsheet")
public class JobSheetController {
    private JobSheetService service;

    //add jobsheet
    @PostMapping("/add")
    public ResponseEntity<JobSheet>CreateJobSheet(@RequestBody JobSheet sheet){
        JobSheet savedto= service.AddJobSheet(sheet);
        return new ResponseEntity<>(savedto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobSheet>getById(@PathVariable("id") Integer clientId){
       JobSheet dto= service.getById(clientId);
       return new ResponseEntity<>(dto,HttpStatus.FOUND);

    }
    @GetMapping("/all")
    public ResponseEntity<List<JobSheet>>getAllJob(){
        List<JobSheet>listsheet= service.getAllJobs();
        return new ResponseEntity<>(listsheet,HttpStatus.FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable ("id") Integer clientId){
        service.deleteById(clientId);
        return new ResponseEntity<>("record deleted successfully...",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateById(@PathVariable("id") Integer clientId,JobSheet updatedClient){
        JobSheet updated=service.updateJobSheet(clientId,updatedClient);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
