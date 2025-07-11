package com.silvertouch.java.controller;

import com.silvertouch.java.dtos.DepartmentDTO;
import com.silvertouch.java.dtos.EmpResDTO;
import com.silvertouch.java.dtos.EmployeeDTO;
import com.silvertouch.java.model.Employee;
import com.silvertouch.java.repo.EmployeeRepository;
import com.silvertouch.java.service.DepartmentService;
import com.silvertouch.java.service.ReportService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService service;
    private final ReportService reportService;
    private final EmployeeRepository employeeRepo;

    public DepartmentController(DepartmentService service, ReportService reportService, EmployeeRepository employeeRepo) {
        this.service = service;
        this.reportService = reportService;
        this.employeeRepo = employeeRepo;
    }

    @PostMapping(value = "/addDepartment")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody @Valid DepartmentDTO dto) {
        return ResponseEntity.ok(service.addDepartment(dto));
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/departments/{deptId}/employees")
    public List<EmpResDTO> getEmployeesInDept(@PathVariable String deptId) {
        return service.getEmployeesByDept(Long.parseLong(deptId));
    }

    @GetMapping("/employees/{empId}")
    public EmpResDTO getEmployeesInDept1(@PathVariable String empId) {
        return service.getEmployeesById(Long.parseLong(empId));
    }

    @PostMapping("/departments/{deptId}/employees")
    public ResponseEntity<EmployeeDTO> addEmployee(
            @PathVariable String deptId,
            @RequestBody @Valid EmployeeDTO dto) {
        return ResponseEntity.ok(service.addEmployeeToDepartment(Long.parseLong(deptId), dto));
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String empId) {
        service.deleteEmployee(Long.parseLong(empId));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reports/employees-by-dept")
    public ResponseEntity<byte[]> getEmployeesByDepartmentReport() {
        try {
            byte[] pdf = reportService.generateEmployeesByDepartmentReport();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees_by_department.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable String empId ,
            @RequestBody @Valid EmployeeDTO dto) {
        return ResponseEntity.ok(service.updateEmployee(Long.parseLong(empId), dto));
    }


}
