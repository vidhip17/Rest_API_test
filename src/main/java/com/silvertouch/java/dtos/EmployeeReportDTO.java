package com.silvertouch.java.dtos;

public class EmployeeReportDTO {

    private String name;
    private String email;
    private String position;
    private double salary;
    private String departmentName;
    private String departmentLocation;

    public EmployeeReportDTO(String name, String email, String position, double salary, String name1, String location) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.departmentName = name1;
        this.departmentLocation = location;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDepartmentLocation() { return departmentLocation; }
    public void setDepartmentLocation(String departmentLocation) { this.departmentLocation = departmentLocation; }
}
