package calculator.model;

import calculator.model.interfaces.СomputationModel;

/**
 * Модель для выполнения операции возведения в степень.
 */
public class ExponentiationModel extends СomputationModel {
    /**
     * Метод для получения результата возведения в степень.
     *
     * @return Результат деления.
     */
    @Override
    public Double result() {
        return Math.pow(a, b);
    }
}
