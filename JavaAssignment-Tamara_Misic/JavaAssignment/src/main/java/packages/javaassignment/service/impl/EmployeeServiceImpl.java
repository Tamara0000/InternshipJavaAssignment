package packages.javaassignment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import packages.javaassignment.entities.Employee;
import packages.javaassignment.entities.Task;
import packages.javaassignment.repository.EmployeeRepository;
import packages.javaassignment.service.EmployeeService;
import packages.javaassignment.service.TaskService;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskService taskService;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        Employee employee1 = employeeRepository.findByEmail(employee.getEmail());
        if(employee1 == null){
            //Ovaj employee ne postoji jos uvek u bazi
            return employeeRepository.save(employee);
        }else {
            //Duplikat
           throw new Exception("Employee with that email already exists in db!");
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, int employeeId) {
        Employee employeeUpdate = employeeRepository.findById(employeeId).get();
        employeeUpdate.setCompany(employee.getCompany());
        employeeUpdate.setEmployeeType(employee.getEmployeeType());
        employeeUpdate.setEmail(employee.getEmail());
        employeeUpdate.setMonthlySalary(employee.getMonthlySalary());
        employeeUpdate.setPhoneNumber(employee.getPhoneNumber());
        return employeeRepository.save(employeeUpdate);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getBusiestEmployees() {
        List<Task> tasks = taskService.getPastMonthTasks();
        Map<Employee, Integer> assignees = new HashMap<Employee, Integer>();
        for (int i = 0; i < tasks.size(); i++) {
            if (!assignees.containsKey(tasks.get(i).getAssignee())) {
                assignees.put(tasks.get(i).getAssignee(), 1);
            }else {
                assignees.replace(tasks.get(i).getAssignee(),assignees.get(tasks.get(i).getAssignee())+1);
            }
        }
        List<Map.Entry<Employee, Integer>> sorted = new ArrayList<>(assignees.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Employee> firstFive = new ArrayList<>();
        for (int i = 0; i < sorted.size(); i++) {
            if (i < 5) {
                firstFive.add(sorted.get(i).getKey());
            } else {
                break;
            }
        }
        return firstFive;
    }

    @Override
    public int averagePay() {
        List<Employee> allEmployees = employeeRepository.findAll();
        int salary = 0;
        for(Employee employee: allEmployees){
            salary += employee.getMonthlySalary();
        }
        int average = salary/allEmployees.size();
        return average;
    }

    @Override
    public List<Employee> aboveAverageMontlySalary(int absSalary) {
        return employeeRepository.findAllByMonthlySalaryIsGreaterThan(averagePay());
    }

    @Override
    public List<Employee> findAllByEmployeeType(String employeeType) {
        return employeeRepository.findAllByEmployeeType_TypeName(employeeType);
    }

    @Override
    public List<Employee> findEmployees(LocalDate date) {
        return employeeRepository.findEmployees(date);
    }

    @Override
    public List<Employee> findAllByCompanyName(String companyName) {
        return employeeRepository.findAllByCompany_Name(companyName);
    }
}
