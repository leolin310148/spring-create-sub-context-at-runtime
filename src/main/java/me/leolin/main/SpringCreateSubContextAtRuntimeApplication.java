package me.leolin.main;

import me.leolin.main.entity.CompanyEntity;
import me.leolin.main.repository.CompanyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCreateSubContextAtRuntimeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringCreateSubContextAtRuntimeApplication.class, args);


        CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
        companyRepository.save(new CompanyEntity("1","Company A","db_comp_A"));
        companyRepository.save(new CompanyEntity("2","Company B","db_comp_B"));
        companyRepository.save(new CompanyEntity("3","Company C","db_comp_C"));


    }
}
