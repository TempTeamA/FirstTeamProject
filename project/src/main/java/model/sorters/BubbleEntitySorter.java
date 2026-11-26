package model.sorters;

import model.abstractions.EntitySorter;
import model.comparators.EvenNumericFieldComparator;
import shared.entites.abstractions.Entity;
import shared.entites.abstractions.EntityCollection;
import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BubbleEntitySorter extends EntitySorter {

    private final Logger logger;

    public BubbleEntitySorter(Comparator<Entity> comparator, Logger logger) {
        super(Objects.requireNonNull(comparator, "Comparator must not be null"));
        this.logger = logger;
    }

    @Override
    public EntityCollection sortEntities(EntityCollection entities) {
        if (entities == null) {
            log(Level.WARNING, "Передана пустая (null) коллекция для сортировки");
            return null;
        }

        List<Entity> list = entities.getEntityList();
        if (list == null || list.size() < 2) {
            log(Level.INFO, "Сортировка не требуется: элементов меньше 2");
            return entities;
        }

        if (comparator instanceof EvenNumericFieldComparator evenComparator) {
            bubbleSortEvenOnly(list, evenComparator);
            log(Level.INFO, "Пузырьковая сортировка (только чётные значения) выполнена");
        } else {
            bubbleSortStandard(list);
            log(Level.INFO, "Базовая пузырьковая сортировка выполнена");
        }

        return entities;
    }

    private void bubbleSortStandard(List<Entity> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                Entity current = list.get(j);
                Entity next = list.get(j + 1);

                if (comparator.compare(current, next) > 0) {
                    list.set(j, next);
                    list.set(j + 1, current);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void bubbleSortEvenOnly(List<Entity> list, EvenNumericFieldComparator evenComparator) {
        int n = list.size();
        int[] evenIndices = new int[n];
        int evenCount = 0;

        for (int i = 0; i < n; i++) {
            if (evenComparator.isEvenEntity(list.get(i))) {
                evenIndices[evenCount++] = i;
            }
        }

        if (evenCount < 2) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < evenCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < evenCount - 1 - i; j++) {
                int idx1 = evenIndices[j];
                int idx2 = evenIndices[j + 1];

                Entity item1 = list.get(idx1);
                Entity item2 = list.get(idx2);

                if (evenComparator.compare(item1, item2) > 0) {
                    list.set(idx1, item2);
                    list.set(idx2, item1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void log(Level level, String message) {
        if (logger != null) {
            logger.log(level, message);
        }
    }
}

// rpath://project/src/main/java/model/sorters/BubbleEntitySorter.java
