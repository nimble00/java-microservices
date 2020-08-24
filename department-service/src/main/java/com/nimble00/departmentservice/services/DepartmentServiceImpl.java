package com.nimble00.departmentservice.services;

import com.nimble00.departmentservice.models.Department;
import com.nimble00.departmentservice.repository.DepartmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        super();
        this.departmentRepo = departmentRepo;
    }

    @Override
    @Transactional
    public Optional<Department> getDepartmentById(Integer departmentId) {
        // TODO Auto-generated method stub
        return departmentRepo.findById(departmentId);
    }

    @Override
    @Transactional
    public Iterable<Department> findAllDepartment() {
        // TODO Auto-generated method stub
        return departmentRepo.findAll();
    }
}
