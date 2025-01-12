package com.dev.spring_boot_jpa_hibernate_advanced;

import com.dev.spring_boot_jpa_hibernate_advanced.dao.AppDAO;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Course;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Instructor;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.InstructorDetail;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SuppressWarnings({"DuplicatedCode"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);

//            findInstructorSummaryById(appDAO);

//            deleteInstructorById(appDAO);

//            findInstructorDetailById(appDAO);

//            deleteInstructorDetailById(appDAO);

//            createInstructorWithCourses(appDAO);

//            findCoursesForInstructorId(appDAO);

//            findInstructorFullInfoById(appDAO);

//            updateInstructor(appDAO);

//            updateCourse(appDAO);

//            deleteCourseById(appDAO);

//             createCourseAndReviews(appDAO);

//             retrieveCourseAndReviews(appDAO);

//            deleteCourseAndReviews(appDAO);

        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {

        Course tempCourse = new Course("Pacman - How To Score One Million Points");

        tempCourse.addReview(new Review("Great course ... loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        System.out.println("---> Saving the course: " + tempCourse + " ...");

        appDAO.save(tempCourse);

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorDetailById
    private void deleteCourseById(AppDAO appDAO) {
        int id = 15;

        System.out.println("---> Deleting the course with the id: " + id);

        appDAO.deleteCourseById(id);

        System.out.println("---> Operation completed.");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        System.out.println("---> Finding the course with the id: " + id);

        Course tempCourse = appDAO.findCourseById(id);

        tempCourse.setTitle("course_NO_3_UPDATED");

        appDAO.updateCourse(tempCourse);

        System.out.println("---> Operation completed.");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        tempInstructor.setFirstName("FirstName_UPDATED");

        appDAO.updateInstructor(tempInstructor);

        System.out.println("---> Operation completed.");

    }

    // findInstructorFullInfoById
    private void findInstructorFullInfoById(AppDAO appDAO) {
        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorFullInfoById(id);

        System.out.println("---> instructor: " + tempInstructor);

        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }
    private void findCoursesForInstructorId(AppDAO appDAO) {
        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        System.out.println("---> instructor: " + tempInstructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(id);

        tempInstructor.setCourses(courses);

        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }

    // createInstructorWithCourses
    private void createInstructorWithCourses(AppDAO appDAO) {
        int id = 15;

        Instructor tempInstructor =
                new Instructor("FirstName_" + id, "LastName_" + id, "test." + id + "@email.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://wwww.youtube/channel/" + id, "gaming_" + id);
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("course_NO_" + (id + 2));
        Course tempCourse2 = new Course("course_NO_" + (id + 3));
        tempInstructor.addCourse(tempCourse1);
        tempInstructor.addCourse(tempCourse2);

        System.out.println("---> Saving instructor with the id : " + id + " ...");

        appDAO.saveInstructor(tempInstructor);

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorDetailById
    private void deleteInstructorDetailById(AppDAO appDAO) {
        int id = 18;

        System.out.println("---> Deleting the instructorDetail with the id: " + id);

        appDAO.deleteInstructorDetailById(id);

        System.out.println("---> Operation completed.");
    }

    // findInstructorDetailById
    private void findInstructorDetailById(AppDAO appDAO) {
        int id = 7;

        System.out.println("---> Finding the instructorDetail with the id: " + id);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);

        System.out.println("---> tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("---> instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("---> Operation completed.");
    }

    // deleteInstructorById
    private void deleteInstructorById(AppDAO appDAO) {
        int id = 3;

        System.out.println("---> Deleting the instructor with the id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("---> Operation completed.");
    }

    // findInstructorSummaryById
    private void findInstructorById(AppDAO appDAO) {
        int id = 1;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorSummaryById(id);

        System.out.println("---> instructor: " + tempInstructor);
        System.out.println("---> instructorDetail: " + tempInstructor.getInstructorDetail());
        System.out.println("---> courses: " + tempInstructor.getCourses());

        System.out.println("---> Operation completed.");
    }

    // createInstructor
    private void createInstructor(AppDAO appDAO) {
        int id = 5;

        Instructor tempInstructor =
                new Instructor("FirstName_" + id, "LastName_" + id, "test." + id + "@email.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://wwww.youtube/channel/" + id, "code_" + id);

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("---> Saving instructor: " + tempInstructor);

        appDAO.saveInstructor(tempInstructor);

        System.out.println("---> Operation completed.");
    }

}
