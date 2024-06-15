package ec.edu.uce.ProyectoRelacionesDDBB.view;

import ec.edu.uce.ProyectoRelacionesDDBB.model.*;
import ec.edu.uce.ProyectoRelacionesDDBB.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class View implements CommandLineRunner {

    private final EmployeeService employeeService;

    public View(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @Transactional
    public void run(String... args) {

        createOneToOneExample();

        createOneToManyExample();


        createManyToOneExample();


        createManyToManyExample();
    }

    private void createOneToOneExample() {
        System.out.println("----- EJEMPLO DE UNO A UNO -----");

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");

        Role role = new Role();
        role.setName("Desarrollador");
        role.setEmployee(employee);
        employee.setRole(role);

        employeeService.saveEmployee(employee);

        System.out.println("Empleado Creado con Rol: " + employee);
        System.out.println("Rol Creado: " + role);
        System.out.println("Esto demuestra una relación Uno a Uno donde cada empleado tiene exactamente un rol y viceversa.");
    }

    private void createOneToManyExample() {
        System.out.println("----- EJEMPLO DE UNO A MUCHOS -----");

        Department department = new Department();
        department.setName("Recursos Humanos");

        Employee employee1 = new Employee();
        employee1.setName("Jane Smith");
        employee1.setEmail("jane.smith@example.com");
        employee1.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setName("Bob Johnson");
        employee2.setEmail("bob.johnson@example.com");
        employee2.setDepartment(department);

        department.getEmployees().add(employee1);
        department.getEmployees().add(employee2);

        employeeService.saveDepartment(department);

        System.out.println("Departamento Creado con Empleados: " + department);
        System.out.println("Empleado 1: " + employee1);
        System.out.println("Empleado 2: " + employee2);
        System.out.println("Esto demuestra una relación Uno a Muchos donde un departamento puede tener múltiples empleados.");
    }

    private void createManyToOneExample() {
        System.out.println("----- EJEMPLO DE MUCHOS A UNO -----");

        Department salesDepartment = new Department();
        salesDepartment.setName("Ventas");
        employeeService.saveDepartment(salesDepartment);

        Employee employee = new Employee();
        employee.setName("Alice Brown");
        employee.setEmail("alice.brown@example.com");
        employee.setDepartment(salesDepartment);

        employeeService.saveEmployee(employee);

        System.out.println("Empleado Creado en el Departamento de Ventas: " + employee);
        System.out.println("Departamento de Ventas: " + salesDepartment);
        System.out.println("Esto demuestra una relación Muchos a Uno donde múltiples empleados pueden pertenecer a un departamento.");
    }

    private void createManyToManyExample() {
        System.out.println("----- EJEMPLO DE MUCHOS A MUCHOS -----");

        Project project1 = new Project();
        project1.setName("Proyecto A");

        Project project2 = new Project();
        project2.setName("Proyecto B");

        employeeService.saveProject(project1);
        employeeService.saveProject(project2);

        Employee employee1 = new Employee();
        employee1.setName("Charlie Davis");
        employee1.setEmail("charlie.davis@example.com");
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);

        Employee employee2 = new Employee();
        employee2.setName("Diana Evans");
        employee2.setEmail("diana.evans@example.com");
        employee2.getProjects().add(project1);

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);

        System.out.println("Empleados Creado con Proyectos: " + employee1 + " y " + employee2);
        System.out.println("Proyecto 1: " + project1);
        System.out.println("Proyecto 2: " + project2);
        System.out.println("Esto demuestra una relación Muchos a Muchos donde los empleados pueden participar en múltiples proyectos y los proyectos pueden tener múltiples empleados.");
    }
}
