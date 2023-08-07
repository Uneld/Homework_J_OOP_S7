package calculator.app;

import calculator.model.*;
import calculator.presenter.CalculatorPresenter;
import calculator.view.CalculatorView;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Класс приложения для запуска бесконечного цикла для непрерывной работы.
 */
public class CalculatorApp {

    /**
     * Экземпляр класса {@link Logger}, используемого для логирования.
     */
    private static Logger LOGGER;

    static {
        try {
            // Открываем файл с конфигурацией логирования
            FileInputStream ins = new FileInputStream("src/calculator/logger_config/logger.config");
            // Читаем конфигурацию логирования из файла
            LogManager.getLogManager().readConfiguration(ins);
            // Создаем экземпляр класса Logger с именем класса CalculatorApp
            LOGGER = Logger.getLogger(CalculatorApp.class.getName());
        } catch (Exception e) {
            // Выводим сообщение об ошибке в консоль
            e.printStackTrace();
        }
    }

    /**
     * Экземпляр класса {@link CalculatorView}.
     */
    private final CalculatorView calculatorView = new CalculatorView();

    /**
     * Экземпляр класса, содержащего список моделей вычислений.
     */
    private final DataModels models = new DataModels();

    /**
     * Экземпляр класса {@link CalculatorPresenter}.
     */
    private final CalculatorPresenter presenter = new CalculatorPresenter(calculatorView, models);

    /**
     * Флаг, указывающий, продолжать работу приложения или нет.
     */
    private boolean isRunning = true;

    /**
     * Метод для инициализации моделей вычислений.
     */
    private void initializeModels() {
        LOGGER.info("Initializing models for calculator");
        models.addCalculationModel(new AdditionModel());
        models.addCalculationModel(new DivisionModel());
        models.addCalculationModel(new MultiplicationModel());
        models.addCalculationModel(new SubtractionModel());
        models.addCalculationModel(new ExponentiationModel());
    }

    /**
     * Метод для отображения приветственного сообщения.
     */
    private void displayWelcomeMessage() {
        LOGGER.info("Displaying welcome message");
        calculatorView.displayMessage("Запуск приложения простой калькулятор!");
    }

    /**
     * Метод для выполнения операции вычислений.
     */
    private void performOperation() {
        presenter.onOperation();
        String operator = presenter.getOperator();
        LOGGER.info("Performing calculations for operator \"" + operator + "\"");
    }


    /**
     * Метод для запроса у пользователя продолжения работы приложения.
     *
     * @return true, если пользователь хочет продолжить работу, иначе false.
     */
    private boolean requestToContinue() {
        LOGGER.info("Requesting user input to continue work");
        return calculatorView.requestToContinue();
    }

    /**
     * Метод для отображения сообщения о завершении работы приложения.
     */
    private void displayGoodbyeMessage() {
        LOGGER.info("Displaying goodbye message\n");
        calculatorView.displayMessage("Приложение завершено.");
    }

    /**
     * Метод для запуска приложения.
     */
    public void start() {
        // Инициализируем модели вычислений
        initializeModels();
        // Отображаем приветственное сообщение
        displayWelcomeMessage();
        // Входим в бесконечный цикл
        while (isRunning) {
            // Выполняем операцию вычислений
            performOperation();
            // Запрашиваем у пользователя продолжение работы или остановку приложения
            isRunning = requestToContinue();
        }
        // Отображаем сообщение о завершении работы приложения
        displayGoodbyeMessage();
    }
}