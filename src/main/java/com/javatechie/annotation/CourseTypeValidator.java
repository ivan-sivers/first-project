package com.javatechie.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CourseTypeValidator implements ConstraintValidator<CourseTypeAnnotation, String> {
    @Override
    public boolean isValid(String courseType, ConstraintValidatorContext constraintValidatorContext) {
        //our validation logic.
        List<String> list = Arrays.asList("LIVE", "RECORDING");
        return list.contains(courseType);
    }
}
