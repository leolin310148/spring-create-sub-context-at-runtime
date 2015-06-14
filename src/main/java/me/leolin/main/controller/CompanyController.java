package me.leolin.main.controller;

import me.leolin.main.entity.CompanyEntity;
import me.leolin.main.service.CompanyService;
import me.leolin.sub.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Leolin
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CompanyEntity> getAllCompany() {
        return companyService.getAllCompany();
    }

    @RequestMapping(value = "/{companyId}/employee", method = RequestMethod.GET)
    public List<EmployeeEntity> getAllEmployee(@PathVariable("companyId") String companyId) {
        return companyService.getAllEmployees(companyId);
    }

    @RequestMapping(value = "/{companyId}/employee", method = RequestMethod.POST)
    public void createEmployee(@PathVariable("companyId") String companyId, @RequestBody EmployeeEntity employeeEntity, HttpServletResponse response
    ) {
        companyService.createEmployee(companyId, employeeEntity);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
