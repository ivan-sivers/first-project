package com.javatechie.controller;

//import com.javatechie.dto.Course;
import com.javatechie.dto.CourseRequestDTO;
import com.javatechie.dto.CourseResponseDTO;
import com.javatechie.dto.ServiceResponse;
import com.javatechie.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResponse<CourseResponseDTO> addCourse(@RequestBody @Valid CourseRequestDTO course) {
        ServiceResponse<CourseResponseDTO> serviceResponse = new ServiceResponse<>();
        CourseResponseDTO newCourse = courseService.onboardNewCourse(course);
        serviceResponse.setStatus(HttpStatus.CREATED);
        serviceResponse.setResponse(newCourse);
        return serviceResponse;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ServiceResponse<List<CourseResponseDTO>> findAllCourse() {
        List<CourseResponseDTO> courses = courseService.viewAllCourses();
        return new ServiceResponse<>(HttpStatus.OK, courses, null);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ServiceResponse<CourseResponseDTO> getCourseById(@PathVariable(name = "id") Integer id) {
        CourseResponseDTO course = courseService.findByCourseId(id);
        return new ServiceResponse<>(HttpStatus.OK, course, null);
    }

    @RequestMapping(value = "/getByParam", method = RequestMethod.GET)
    public ServiceResponse<CourseResponseDTO> getCourseByIdParam(@RequestParam(name = "courseId") Integer courseId) {
        CourseResponseDTO course = courseService.findByCourseId(courseId);
        return new ServiceResponse<>(HttpStatus.OK, course, null);
    }

    @DeleteMapping(value = "/{courseId}")
    public ServiceResponse<String> deleteCourseById(@PathVariable(value = "courseId") Integer courseId) {
        courseService.deleteCourse(courseId);
        return new ServiceResponse<>(HttpStatus.OK, "course deleted successfully with id : " + courseId, null);
    }

    @PutMapping(value = "/{courseId}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable(value = "courseId") int courseId,@RequestBody CourseRequestDTO course) {
        CourseResponseDTO updatedCourse = courseService.updateCourse(courseId, course);
        return new ServiceResponse<>(HttpStatus.OK, updatedCourse, null);
    }
}
