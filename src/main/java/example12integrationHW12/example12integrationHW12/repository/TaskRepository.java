package example12integrationHW12.example12integrationHW12.repository;


import example12integrationHW12.example12integrationHW12.model.Task;
import example12integrationHW12.example12integrationHW12.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Получить список задач по их статусу
     * @param status
     * @return
     */
    List<Task> findByStatus(TaskStatus status);
}