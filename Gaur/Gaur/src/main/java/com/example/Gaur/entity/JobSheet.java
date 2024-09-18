package com.example.Gaur.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Job sheet")

public class JobSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client Id")
    private Integer clientId;

    @Column(name = "Client Name")
    private String clientName;

    @Column(name = "Client Info")
    private String contact;

    @Column(name = "Received Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receivedDate ;

    @Column(name = "Inventory Received")
    private boolean ReceivedInventory;

    @Column(name = "Upload Inventry")
    @Lob
    private byte[] uploadInventory;

    @Column(name = "Report Issue")
    private String reportedIssue;

    @Column(name = "Client Note")
    private String clientNote;

    @Column(name = "Assigned Technician")
    private String assignedTechnician;

    @Column(name = "Deadline")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date Deadline;

    @Column(name = "Estimate Amount")
    private String estimateAmount;

    @Column(name = "Status")
    private String status;



}
