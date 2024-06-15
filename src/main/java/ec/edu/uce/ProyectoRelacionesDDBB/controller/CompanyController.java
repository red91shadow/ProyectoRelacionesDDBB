package ec.edu.uce.ProyectoRelacionesDDBB.controller;

import ec.edu.uce.ProyectoRelacionesDDBB.model.*;
import ec.edu.uce.ProyectoRelacionesDDBB.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        companyService.addEmployee(employee);
        return "Employee added: " + employee.getName();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return companyService.getAllEmployees();
    }

    @PostMapping("/addRole")
    public String addRole(@RequestBody Role role) {
        companyService.addRole(role);
        return "Role added: " + role.getName();
    }

    @PostMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department) {
        companyService.addDepartment(department);
        return "Department added: " + department.getName();
    }

    @PostMapping("/addProject")
    public String addProject(@RequestBody Project project) {
        companyService.addProject(project);
        return "Project added: " + project.getName();
    }
}
