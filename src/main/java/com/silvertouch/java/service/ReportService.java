package com.silvertouch.java.service;

import com.silvertouch.java.dtos.EmployeeReportDTO;
import com.silvertouch.java.model.Department;
import com.silvertouch.java.model.Employee;
import com.silvertouch.java.repo.DepartmentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final DepartmentRepository empRepo;

    public ReportService(DepartmentRepository empRepo) {
        this.empRepo = empRepo;
    }

    public List<EmployeeReportDTO> getEmployeeReportData() {
        List<Department> departments = empRepo.findAllDepartmentsWithEmployees();

        List<EmployeeReportDTO> data = new ArrayList<>();
        for (Department d : departments) {
            if (d.getEmployees() != null) {
                for (Employee e : d.getEmployees()) {
                    data.add(new EmployeeReportDTO(
                            e.getName(),
                            e.getEmail(),
                            e.getPosition(),
                            e.getSalary(),
                            d.getName(),
                            d.getLocation()
                    ));
                }
            }
        }
        return data;
    }

    public byte[] generateEmployeesByDepartmentReport() throws Exception {
        InputStream reportStream = new ClassPathResource("reports/employees.jrxml").getInputStream();

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        List<EmployeeReportDTO> data = getEmployeeReportData();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Employees by Department");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
