package calculator.model;

import calculator.model.interfaces.СomputationModel;

/**
 * Модель для выполнения операции вычитания.
 */
public class SubtractionModel extends СomputationModel {
    public SubtractionModel() {
    }

    /**
     * Метод для получения результата вычитания.
     *
     * @return Результат умножения.
     */
    @Override
    public Double result() {
        return a - b;
    }
}
