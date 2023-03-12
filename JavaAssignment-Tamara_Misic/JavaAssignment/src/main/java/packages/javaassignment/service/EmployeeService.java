package packages.javaassignment.service;

import packages.javaassignment.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee saveEmployee(Employee employee) throws Exception;
    Employee updateEmployee(Employee employee, int employeeId);
    void deleteEmployee(Integer id);
    List<Employee> getBusiestEmployees();
    int averagePay();
    List<Employee> aboveAverageMontlySalary(int absSalary);
    List<Employee> findAllByEmployeeType(String employeeType);
    List<Employee> findEmployees(LocalDate date);
    List<Employee> findAllByCompanyName(String companyName);
}
