package com.dev.spring_boot_jpa_hibernate_advanced.dao;

import com.dev.spring_boot_jpa_hibernate_advanced.entity.Course;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Instructor;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void saveInstructor(Instructor instructor);

    Instructor findInstructorSummaryById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorFullInfoById(int id);
}
