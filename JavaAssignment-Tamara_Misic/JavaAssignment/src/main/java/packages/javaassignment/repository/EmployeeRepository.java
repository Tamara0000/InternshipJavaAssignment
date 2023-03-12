package packages.javaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import packages.javaassignment.entities.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
    List<Employee> findAllByMonthlySalaryIsGreaterThan(int absSalary);
    List<Employee> findAllByEmployeeType_TypeName(String employeeType);
    List<Employee> findAllByCompany_Name(String companyName);

    @Query(value="SELECT * FROM employee e JOIN meeting_employee me ON e.employee_id = me.employee_id" +
            " JOIN meeting m ON me.meeting_id=m.meeting_id WHERE m.date = :#{#date}",
            nativeQuery = true)
    List<Employee> findEmployees(@Param("date")LocalDate date);

}
