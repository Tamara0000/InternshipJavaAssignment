package packages.javaassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee_type")
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_type_id", nullable = false)
    private Integer id;

    @Column(name = "type_name", nullable = false, length = 28)
    private String typeName;

}