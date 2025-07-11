package com.example.demo.dtos;

import java.util.List;

public record DepartmentDTO(String name, String location, List<EmployeeDTO> employees) {

}

