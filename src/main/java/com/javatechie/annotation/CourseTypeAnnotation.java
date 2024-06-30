package com.javatechie.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CourseTypeValidator.class)
public @interface CourseTypeAnnotation {

    //it is the default message we show if validation is false.
    String message() default "Course type should be either LIVE or recording";

    //I Don't know the purpose of these two yet , but they are a must to define
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
