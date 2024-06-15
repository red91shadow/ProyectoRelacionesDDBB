package ec.edu.uce.ProyectoRelacionesDDBB.services;

import ec.edu.uce.ProyectoRelacionesDDBB.interfaces.DepartmentRepository;
import ec.edu.uce.ProyectoRelacionesDDBB.interfaces.EmployeeRepository;
import ec.edu.uce.ProyectoRelacionesDDBB.interfaces.ProjectRepository;
import ec.edu.uce.ProyectoRelacionesDDBB.interfaces.RoleRepository;
import ec.edu.uce.ProyectoRelacionesDDBB.model.Department;
import ec.edu.uce.ProyectoRelacionesDDBB.model.Employee;
import ec.edu.uce.ProyectoRelacionesDDBB.model.Project;
import ec.edu.uce.ProyectoRelacionesDDBB.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
}
