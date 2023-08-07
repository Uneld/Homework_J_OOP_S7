package calculator.model.interfaces;

/**
 * Определяем абстрактный класс имплементирующий интерфейс {@link Model} о том что требуется хранение двух переменных
 * для дальнейших вычислений и методы их назначения
 */
public abstract class СomputationModel implements Model {
    /**
     * Первое число для сложения.
     */
    protected Double a;
    /**
     * Второе число для расчета.
     */
    protected Double b;

    /**
     * Метод для установки первого числа.
     *
     * @param a Первое число для расчета.
     */
    @Override
    public void setA(Double a) {
        this.a = a;
    }

    /**
     * Метод для установки второго числа.
     *
     * @param b Второе число для расчета.
     */
    @Override
    public void setB(Double b) {
        this.b = b;
    }
}
