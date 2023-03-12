package packages.javaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import packages.javaassignment.entities.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM task WHERE MONTH(due_date) = MONTH(DATE_SUB(CURRENT_DATE,INTERVAL 1 MONTH))",
            nativeQuery = true)
    List<Task> findAllByDueDate(int month);

    Task findByTitle(String title);
}
