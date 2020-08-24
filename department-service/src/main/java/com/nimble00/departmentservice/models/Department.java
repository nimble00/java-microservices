package com.nimble00.departmentservice.models;

import javax.persistence.*;

@Entity
@Table(name = "department_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "location")
    private String departmentLocation;
    public Department() {
        super();
    }
    public Department(Integer departmentId, String departmentName, String departmentLocation) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }
    public Department(String departmentName, String departmentLocation) {
        super();
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentLocation() {
        return departmentLocation;
    }
    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
}
