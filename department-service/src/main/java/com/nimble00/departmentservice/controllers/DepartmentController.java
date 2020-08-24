package com.nimble00.departmentservice.controllers;

import com.nimble00.departmentservice.models.Department;
import com.nimble00.departmentservice.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }
    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<Optional<Department>> restGetDepartmentById(@PathVariable("departmentId") Integer departmentId) {
        return new ResponseEntity<Optional<Department>>(departmentService.getDepartmentById(departmentId),HttpStatus.FOUND);
    }
    @GetMapping("/departments")
    public ResponseEntity<Iterable<Department>> restGetAllDepartment() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartment());
    }
}
