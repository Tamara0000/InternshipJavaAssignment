package packages.javaassignment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 64, unique=true)
    private String title;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "assignee", nullable = false)
    private Employee assignee;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

}