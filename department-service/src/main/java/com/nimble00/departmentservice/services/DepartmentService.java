package com.nimble00.departmentservice.services;

import com.nimble00.departmentservice.models.Department;

import java.util.Optional;

public interface DepartmentService {

    public Optional<Department> getDepartmentById(Integer departmentId);
    public Iterable<Department> findAllDepartment();

}