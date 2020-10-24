package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    public boolean isValid(String theCode,
                           ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }else {
            result = true;
        }

        return result;
    }
}
