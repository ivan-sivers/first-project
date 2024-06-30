package com.javatechie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {

    private int courseId;
    private String name;
    private String trainerName;
    private String duration;        //days
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    private String courseType;
    private double fees;
    private boolean isCertificateAvailable;
    private String description;
    //extra added field in response DTO
    private String courseUniqueCode;
    private String email;
    private String contact;
}
