package com.dev.sprint_boot_rest_basics_2.dao;

import com.dev.sprint_boot_rest_basics_2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e from Employee e", Employee.class
        );

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
