package calculator.model;

import calculator.model.interfaces.СomputationModel;

/**
 * Модель для выполнения операции сложения.
 */
public class AdditionModel extends СomputationModel {
    public AdditionModel() {
    }

    /**
     * Метод для получения результата сложения.
     *
     * @return Результат сложения.
     */
    @Override
    public Double result() {
        return a + b;
    }
}
