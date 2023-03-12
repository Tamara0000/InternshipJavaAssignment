package packages.javaassignment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import packages.javaassignment.entities.Employee;
import packages.javaassignment.service.EmployeeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @RequestMapping(value = "/busiestEmployees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> showBusiestEmployees(){
        return ResponseEntity.ok(employeeService.getBusiestEmployees());
    }

    @RequestMapping(value = "/aboveAverageSalary", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> aboveAverageMontlySalary(){
        return ResponseEntity.ok(employeeService.aboveAverageMontlySalary(employeeService.averagePay()));
    }
    @RequestMapping(value = "/{employeeType}", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllByEmployeeType(@PathVariable String employeeType){
        return ResponseEntity.ok(employeeService.findAllByEmployeeType(employeeType));
    }

    @RequestMapping(value = "/meeting/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findEmployees(@PathVariable String date){
        LocalDate dateConvert = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return ResponseEntity.ok(employeeService.findEmployees(dateConvert));
    }

    @RequestMapping(value = "/company/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllByCompany(@PathVariable String name){
        return ResponseEntity.ok(employeeService.findAllByCompanyName(name));
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws Exception {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId){
        return ResponseEntity.ok(employeeService.updateEmployee(employee, employeeId));
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
