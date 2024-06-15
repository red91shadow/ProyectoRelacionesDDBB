package ec.edu.uce.ProyectoRelacionesDDBB.interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
