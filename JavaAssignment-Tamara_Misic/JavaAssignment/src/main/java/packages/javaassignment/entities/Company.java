package packages.javaassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Column(name = "adress", nullable = false, length = 64)
    private String adress;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

}