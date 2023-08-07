package calculator.model;

import calculator.model.interfaces.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, содержащий список моделей вычислений.
 */
public class DataModels {
    private final List<Model> modelList;

    /**
     * Конструктор класса {@link DataModels}.
     */
    public DataModels() {
        modelList = new ArrayList<>();
    }

    /**
     * Конструктор класса {@link DataModels}.
     *
     * @param modelList Список моделей вычислений.
     */
    public DataModels(List<Model> modelList) {
        this.modelList = modelList;
    }

    /**
     * Метод для добавления модели вычислений в список.
     *
     * @param model Модель вычислений.
     */
    public void addCalculationModel(Model model) {
        modelList.add(model);
    }

    /**
     * Метод для получения модели вычислений по типу.
     *
     * @param type Тип модели вычислений.
     * @param <T>  Обобщенный тип модели вычислений.
     * @return Модель вычислений или {@code null}, если модель не найдена.
     */
    public <T extends Model> T getModelByType(Class<T> type) {
        for (Model model : modelList) {
            if (type.isInstance(model)) {
                return type.cast(model);
            }
        }
        return null;
    }
}
