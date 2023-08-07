package calculator.model;

import calculator.model.interfaces.СomputationModel;

/**
 * Модель для выполнения операции умножения.
 */
public class MultiplicationModel extends СomputationModel {
    public MultiplicationModel() {
    }

    /**
     * Метод для получения результата умножения.
     *
     * @return Результат умножения.
     */
    @Override
    public Double result() {
        return a * b;
    }
}
