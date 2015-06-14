package me.leolin.sub.repository;

import me.leolin.sub.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leolin
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {
}
