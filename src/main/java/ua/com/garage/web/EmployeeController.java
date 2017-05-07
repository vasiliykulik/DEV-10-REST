package ua.com.garage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.garage.model.Employee;
import ua.com.garage.service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * Created by Vasiliy Kylik on 04.05.2017.
 */
@RestController
public class EmployeeController {

  private EmployeeService employeeService;

  @RequestMapping(value = "/employee", method = RequestMethod.GET)
  public List<Employee> employees(Map<String, Object> model) {
    return employeeService.getEmployees();
  }

  @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
  public Employee employees(@PathVariable String employeeName) {
    return employeeService.getEmployeeByName(employeeName);
  }

  @Autowired
  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
}
