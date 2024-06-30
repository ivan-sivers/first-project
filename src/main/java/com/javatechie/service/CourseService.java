package com.javatechie.service;

import com.javatechie.dao.CourseDao;
import com.javatechie.dto.CourseRequestDTO;
import com.javatechie.dto.CourseResponseDTO;
import com.javatechie.entity.CourseEntity;
import com.javatechie.exception.CourseServiceBusinessException;
import com.javatechie.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class CourseService {

    private CourseDao courseDao;

    //save courseObject in DB
    public CourseResponseDTO onboardNewCourse(CourseRequestDTO courseRequestDTO) {
        //convert DTO to ENTITY
        CourseEntity requestEntity = AppUtils.mapDTOToEntity(courseRequestDTO);
        CourseEntity responseEntity = null;
        //Using CrudRepository's predefined methods.
        try {
            responseEntity = courseDao.save(requestEntity);
            CourseResponseDTO responseDTO = AppUtils.mapEntityToDTO(responseEntity);
            responseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
            return responseDTO;
        } catch (Exception e) {
            throw new CourseServiceBusinessException("onboardNewCourse service method failed");
        }
    }

    //load all the courses from DB
    public List<CourseResponseDTO> viewAllCourses() {
        Iterable<CourseEntity> courseEntities = null;
        try {
            courseEntities = courseDao.findAll();
        } catch (Exception e) {
            throw new CourseServiceBusinessException("viewAllCourses service method fail");
        }

        //Iterable<?> we can convert to Stream<?> using StreamSupport.stream() method
        return StreamSupport.stream(courseEntities.spliterator(), false)
                .map(AppUtils::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    //filter course by course id
    public CourseResponseDTO findByCourseId(Integer courseId) {
            //findById returns optional
          CourseEntity courseEntity = courseDao.findById(courseId).orElseThrow(()->new CourseServiceBusinessException(courseId + " doesn't exist in system"));
          return AppUtils.mapEntityToDTO(courseEntity);
    }

    //deleteCourse
    public void deleteCourse(Integer courseId) {
        courseDao.deleteById(courseId);
    }

    //updateCourse
    public CourseResponseDTO updateCourse(int courseId, CourseRequestDTO courseRequestDTO) {
        //1. get the existing object
        CourseEntity exisitingCourseEntity = courseDao.findById(courseId).orElse(null);
        //just updating one field instead of all, to have less code for demo
        //2.update the object
        exisitingCourseEntity.setCourseType(courseRequestDTO.getCourseType());
        //save the object
        CourseEntity updatedCourseEntity = courseDao.save(exisitingCourseEntity);
        return AppUtils.mapEntityToDTO(updatedCourseEntity);

    }
}
