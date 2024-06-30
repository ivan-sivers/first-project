package com.javatechie.util;

import com.javatechie.dto.CourseRequestDTO;
import com.javatechie.dto.CourseResponseDTO;
import com.javatechie.entity.CourseEntity;

import javax.swing.text.html.parser.Entity;

public class AppUtils {
    //Convert request DTO to Entity
    public static CourseEntity mapDTOToEntity(CourseRequestDTO courseRequestDTO) {
        CourseEntity courseEntity = new CourseEntity();
//        courseEntity.setCourseId(courseRequestDTO.getCourseId());
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setContact(courseRequestDTO.getContact());
        return courseEntity;

    }

    //convert Entity
    public static CourseResponseDTO mapEntityToDTO(CourseEntity entity) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(entity.getCourseId());
        courseResponseDTO.setName(entity.getName());
        courseResponseDTO.setTrainerName(entity.getTrainerName());
        courseResponseDTO.setDuration(entity.getDuration());
        courseResponseDTO.setStartDate(entity.getStartDate());
        courseResponseDTO.setCourseType(entity.getCourseType());
        courseResponseDTO.setFees(entity.getFees());
        courseResponseDTO.setCertificateAvailable(entity.isCertificateAvailable());
        courseResponseDTO.setDescription(entity.getDescription());
//        courseResponseDTO.setCourseUniqueCode();
        courseResponseDTO.setEmail(entity.getEmail());
        courseResponseDTO.setContact(entity.getContact());
        return courseResponseDTO;

    }
}
