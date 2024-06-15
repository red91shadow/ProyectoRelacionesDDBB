package ec.edu.uce.ProyectoRelacionesDDBB.interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {}

