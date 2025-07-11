package com.silvertouch.java.service;

import com.silvertouch.java.dtos.DepartmentDTO;
import com.silvertouch.java.dtos.EmpResDTO;
import com.silvertouch.java.dtos.EmployeeDTO;
import com.silvertouch.java.model.Department;
import com.silvertouch.java.model.Employee;
import com.silvertouch.java.repo.DepartmentRepository;
import com.silvertouch.java.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;

    public DepartmentService(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        this.deptRepo = deptRepo;
        this.empRepo = empRepo;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return deptRepo.findAll().stream().map(this::mapToDTO).toList();
    }

    @Transactional
    public DepartmentDTO addDepartment(DepartmentDTO dto) {
        if (deptRepo.existsByName(dto.name())) {
            throw new IllegalArgumentException("Department with name already exists: " + dto.name());
        }

        Department department = new Department();
        department.setName(dto.name());
        department.setLocation(dto.location());

        deptRepo.save(department);

        return dto;
    }

    @Transactional
    public EmployeeDTO addEmployeeToDepartment(Long deptId, EmployeeDTO dto) {

        Department dept = deptRepo.findById(deptId)
                .orElseThrow(() -> new IllegalArgumentException("Department ID not found: " + deptId));

        if (empRepo.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Employee with email already exists.");
        }

        Employee emp = new Employee(dto.name(), dto.email(), dto.position(), dto.salary(), dept);
        empRepo.save(emp);
        return dto;
    }

    @Transactional
    public void deleteEmployee(Long empId) {
        if (empRepo.findById(empId).isEmpty()) {
            throw new IllegalArgumentException("Employee with id not found: .");
        }
        empRepo.deleteById(empId);
    }

    private DepartmentDTO mapToDTO(Department dept) {
        List<EmployeeDTO> employeeDTOs = dept.getEmployees().stream()
                .map(this::mapToEmployeeDTO)
                .collect(Collectors.toList());

        return new DepartmentDTO(
                dept.getName(),
                dept.getLocation(),
                employeeDTOs
        );
    }

    private EmployeeDTO mapToEmployeeDTO(Employee emp) {
        return new EmployeeDTO(
                emp.getName(),
                emp.getEmail(),
                emp.getPosition(),
                emp.getSalary()
        );
    }

    private EmpResDTO mapToEmployeeResDTO(Employee emp) {
        return new EmpResDTO(
                emp.getId(),
                emp.getName(),
                emp.getEmail(),
                emp.getPosition(),
                emp.getSalary()
        );
    }

    public List<EmpResDTO> getEmployeesByDept(Long deptId) {

        deptRepo.findById(deptId)
                .orElseThrow(() -> new IllegalArgumentException("Department ID not found: " + deptId));
        List<Employee> employees = empRepo.findAllByDepartmentId(deptId);

        return employees.stream()
                .map(this::mapToEmployeeResDTO)
                .collect(Collectors.toList());
    }

    public EmpResDTO getEmployeesById(Long empId) {
        Employee employees = empRepo.findById(empId).orElseThrow(() -> new IllegalArgumentException("Employee ID not found: " + empId));

        return this.mapToEmployeeResDTO(employees);
    }

    @Transactional
    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO dto) {
        Employee existingEmp = empRepo.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Employee ID not found: " + empId));

        // Optional: check email uniqueness if email is being changed
        if (!existingEmp.getEmail().equals(dto.email()) && empRepo.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Another employee already uses this email.");
        }

        existingEmp.setName(dto.name());
        existingEmp.setEmail(dto.email());
        existingEmp.setPosition(dto.position());
        existingEmp.setSalary(dto.salary());

        empRepo.save(existingEmp);
        return dto;
    }
}
