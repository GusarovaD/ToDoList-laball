package main.java.com.student.todo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoManager {
    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== МЕНЕДЖЕР ЗАДАЧ ===");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 2 -> viewTasks();
                case 3 -> deleteTask();
                case 4 -> {
                    saveTasks();
                    System.out.println("Выход из программы. Задачи сохранены.");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n1. Добавить задачу");
        System.out.println("2. Просмотреть задачи");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }



    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }

        System.out.println("\n=== ВАШИ ЗАДАЧИ ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Введите номер задачи для удаления: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Неверный номер задачи!");
            return;
        }

        String removedTask = tasks.remove(taskNumber - 1);
        System.out.println("Задача удалена: " + removedTask);
    }

    private static void saveTasks() {
        System.out.println("Задачи будут сохранены в файл...");
    }
}
