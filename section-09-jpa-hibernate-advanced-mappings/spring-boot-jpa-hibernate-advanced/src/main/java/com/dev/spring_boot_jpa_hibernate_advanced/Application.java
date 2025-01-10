package com.dev.spring_boot_jpa_hibernate_advanced;

import com.dev.spring_boot_jpa_hibernate_advanced.dao.AppDAO;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Instructor;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);

//            findInstructorById(appDAO);

//            deleteInstructorById(appDAO);

//            findInstructorDetailById(appDAO);

//            deleteInstructorDetailById(appDAO);

        };
    }
    private void deleteInstructorDetailById(AppDAO appDAO) {
        int id = 18;

        System.out.println("---> Deleting the instructorDetail with the id: " + id);

        appDAO.deleteInstructorDetailById(id);

        System.out.println("---> Operation completed.");
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        int id = 7;

        System.out.println("---> Finding the instructorDetail with the id: " + id);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);

        System.out.println("---> tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("---> instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("---> Operation completed.");
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int id = 2;

        System.out.println("---> Deleting the instructor with the id: " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("---> Operation completed.");
    }

    private void findInstructorById(AppDAO appDAO) {
        int id = 2;

        System.out.println("---> Finding the instructor with the id: " + id);

        Instructor tempInstructor = appDAO.findInstructorById(id);

        System.out.println("---> instructor: " + tempInstructor);
        System.out.println("---> instructorDetail: " + tempInstructor.getInstructorDetail());

        System.out.println("---> Operation completed.");
    }

    private void createInstructor(AppDAO appDAO) {
        int id = 4;

        Instructor tempInstructor =
                new Instructor("FirstName_" + id, "LastName_" + id, "test." + id + "@email.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("https://wwww.youtube/channel/" + id, "code_" + id);

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("---> Saving instructor: " + tempInstructor);

        appDAO.save(tempInstructor);

        System.out.println("---> Operation completed.");
    }

}
