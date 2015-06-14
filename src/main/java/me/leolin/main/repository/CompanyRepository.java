package me.leolin.main.repository;

import me.leolin.main.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Leolin
 */
public interface CompanyRepository extends JpaRepository<CompanyEntity,String> {
}
