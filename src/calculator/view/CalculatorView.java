package calculator.view;

import java.util.Scanner;

/**
 * Класс CalculatorView представляет собой интерфейс для работы с пользователем через консоль.
 */
public class CalculatorView {
    private final Scanner scanner;

    /**
     * Конструктор класса CalculatorView инициализирует объект Scanner для чтения данных с консоли.
     */
    public CalculatorView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод getValue позволяет получить новое значение из консоли и вывести переданное сообщение.
     *
     * @param title сообщение для вывода
     * @return полученное значение
     */
    public double getValue(String title) {
        System.out.print(title);
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * Метод getOperator позволяет получить оператор и вывести требуемые операторы.
     * @param operators сообщение для требуемых операторов
     * @return полученный оператор
     */
    public String getOperator(String operators) {
        System.out.printf("Введите оператор (%s)\n", operators);
        return scanner.nextLine();
    }

    /**
     * Метод printResult позволяет вывести результат и переданное сообщение.
     *
     * @param result результат
     * @param title  сообщение для вывода
     */
    public void printResult(double result, String title) {
        System.out.printf("%s %.2f\n", title, result);
    }

    /**
     * Метод requestToContinue позволяет запросить у пользователя продолжение работы или выход.
     *
     * @return true, если пользователь хочет продолжить, иначе false
     */
    public boolean requestToContinue() {
        System.out.print("Вы хотите продолжить? (Y - продолжить, остальные - выход): ");
        String choice = scanner.nextLine();
        System.out.println("-------------------------------------");
        return choice.trim().equalsIgnoreCase("Y");
    }

    /**
     * Метод displayMessage позволяет вывести переданное сообщение.
     *
     * @param title сообщение для вывода
     */
    public void displayMessage(String title) {
        System.out.println(title);
        System.out.println("-------------------------------------");
    }
}