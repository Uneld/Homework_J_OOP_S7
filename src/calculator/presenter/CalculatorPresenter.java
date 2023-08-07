package calculator.presenter;

import calculator.model.*;
import calculator.model.interfaces.Model;
import calculator.view.CalculatorView;

/**
 * Определяем presenter с использованием всех моделей вычислений
 */
public class CalculatorPresenter {
    /**
     * Экземпляр класса {@link CalculatorView}.
     */
    private final CalculatorView view;
    /**
     * Экземпляр класса, содержащего модели вычислений.
     */
    private final DataModels models;

    /**
     * Оператор вычислений введенный пользователем.
     */
    String operator;

    /**
     * Метод для получения оператора вычислений.
     *
     * @return строка с оператором вычислений.
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Конструктор класса {@link CalculatorPresenter}.
     *
     * @param view   Экземпляр класса {@link CalculatorView}.
     * @param models Экземпляр класса, содержащего модели вычислений.
     */
    public CalculatorPresenter(CalculatorView view, DataModels models) {
        this.view = view;
        this.models = models;
    }

    /**
     * Метод получения ввода пользователя и вычисления результата
     */
    public void onOperation() {
        //Получаем ввод чисел используя Task1.View
        Double num1 = view.getValue("Введите число 1: ");
        Double num2 = view.getValue("Введите число 2: ");
        //Получаем ввод оператора используя Task1.View
        operator = view.getOperator("+, -, *, /, ^");

        //Выполнение вычислений
        switch (operator) {
            case "+" ->
                //Использование модели суммы
                    useCalculationModel(models.getModelByType(AdditionModel.class), num1, num2, "Сумма = ");
            case "-" ->
                //Использование модели разности
                    useCalculationModel(models.getModelByType(SubtractionModel.class), num1, num2, "Разность = ");
            case "*" ->
                //Использование модели произведения
                    useCalculationModel(models.getModelByType(MultiplicationModel.class), num1, num2, "Произведение = ");
            case "/" ->
                //Использование модели частного
                    useCalculationModel(models.getModelByType(DivisionModel.class), num1, num2, "Частное = ");
            case "^" ->
                //Использование модели частного
                    useCalculationModel(models.getModelByType(ExponentiationModel.class), num1, num2, "Возведение в степень = ");
            //Вывод ошибки
            default -> view.displayMessage("Введен не верный оператор!");
        }
    }

    /**
     * Метод для использования модели вычислений.
     *
     * @param model Модель вычислений.
     * @param num1  Первое число.
     * @param num2  Второе число.
     * @param title Заголовок результата.
     */
    private void useCalculationModel(Model model, Double num1, Double num2, String title) {
        model.setA(num1);
        model.setB(num2);

        Double result = model.result();
        //Вывод на консоль результата с проверкой на null если вычисление провалилось
        if (result != null) {
            //Вывод на консоль результата
            view.printResult(result, title);
        } else {
            //Вывод ошибки
            view.displayMessage("Введены не верные данные");
        }
    }
}
