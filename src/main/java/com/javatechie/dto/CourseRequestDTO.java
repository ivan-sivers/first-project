package com.javatechie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javatechie.annotation.CourseTypeAnnotation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {
    @NotBlank(message = "CourseName should not be null")
    private String name;
    @NotEmpty(message = "TrainerName should not be empty")
    private String trainerName;
    @NotNull(message = "duration is must to be specified")
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "date should not be past date")
    private Date startDate;
    @CourseTypeAnnotation
    private String courseType;
    @Min(value = 1500, message = "course price can't be less that 1500")
    @Max(value = 5000, message = "course price can't be more than 5000")
    private double fees;
    private boolean isCertificateAvailable;
    @NotEmpty(message = "description must be present")
    @Length(min = 5, max = 20)
    private String description;
    @Email(message = "invalid email id")
    private String email;
    @Pattern(regexp = "^[0=9]{10}$")
    private String contact;

}
