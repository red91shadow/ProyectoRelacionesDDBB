package ec.edu.uce.ProyectoRelacionesDDBB.interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
