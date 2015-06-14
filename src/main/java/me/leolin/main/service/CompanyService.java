package me.leolin.main.service;

import me.leolin.main.entity.CompanyEntity;
import me.leolin.main.repository.CompanyRepository;
import me.leolin.sub.JpaConfig;
import me.leolin.sub.entity.EmployeeEntity;
import me.leolin.sub.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

/**
 * @author Leolin
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    private Map<String, ConfigurableApplicationContext> CHILD_CONTEXTS = Collections.synchronizedMap(new HashMap<>());

    public List<CompanyEntity> getAllCompany() {
        return companyRepository.findAll();
    }

    public List<EmployeeEntity> getAllEmployees(String companyId) {
        return getEmployeeRepository(companyId).findAll();
    }

    public void createEmployee(String companyId, EmployeeEntity employeeEntity) {
        getEmployeeRepository(companyId).save(employeeEntity);
    }

    EmployeeRepository getEmployeeRepository(String companyId) {
        if (!CHILD_CONTEXTS.containsKey(companyId)) {
            CompanyEntity companyEntity = Optional.ofNullable(companyRepository.findOne(companyId)).orElseThrow(() -> new EntityNotFoundException(companyId));
            String dbName = companyEntity.getDbName();

            AnnotationConfigApplicationContext subContext = new AnnotationConfigApplicationContext();

            Properties properties = new Properties();
            properties.setProperty("dbName", dbName);

            PropertiesPropertySource propertySource = new PropertiesPropertySource("dbProperties", properties);

            StandardEnvironment env = new StandardEnvironment();
            env.getPropertySources().addLast(propertySource);

            subContext.setEnvironment(env);
            subContext.register(JpaConfig.class);
            subContext.refresh();

            CHILD_CONTEXTS.put(companyId, subContext);
        }

        return CHILD_CONTEXTS.get(companyId).getBean(EmployeeRepository.class);
    }
}
