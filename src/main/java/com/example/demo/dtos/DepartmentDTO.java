package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DepartmentDTO(
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name is Blank")
        String name, String location, List<EmployeeDTO> employees) {

}

