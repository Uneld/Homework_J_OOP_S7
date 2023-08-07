package calculator.model;

import calculator.model.interfaces.СomputationModel;

/**
 * Модель для выполнения операции деления.
 */
public class DivisionModel extends СomputationModel {
    public DivisionModel() {
    }

    /**
     * Метод для получения результата деления.
     *
     * @return Результат деления.
     */
    @Override
    public Double result() {
        if (b != 0) {
            return a / b;
        } else {
            return null;
        }
    }
}
