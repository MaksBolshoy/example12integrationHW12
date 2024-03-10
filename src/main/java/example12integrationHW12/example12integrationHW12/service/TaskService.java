package example12integrationHW12.example12integrationHW12.service;

import example12integrationHW12.example12integrationHW12.model.Task;
import example12integrationHW12.example12integrationHW12.model.TaskStatus;
import example12integrationHW12.example12integrationHW12.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Добавление новой задачи.
     *
     * @param task - новая задача.
     * @return - задача.
     */
    public Task addTask(Task task) {
        return repository.save(task);
    }

    /**
     * Получить все задачи.
     *
     * @return список задач.
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Просмотр задач по статусу
     *
     * @param status статус задачи
     * @return список задач одного статуса
     */
    public List<Task> findByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Изменение статуса задачи
     *
     * @param id   ID задачи
     * @param task задача с новым статусом
     * @return сохраняет новый статут у задачи
     */
    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setStatus(task.getStatus());
            return repository.save(task1);
        } else {
            throw new IllegalArgumentException("Task not found with id");
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}
