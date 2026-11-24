// model/sorters/BubbleEntitySorter.java
package model.sorters;

import model.abstractions.EntitySorter;
import shared.entites.abstractions.EntityCollection;

import java.util.Comparator;

public class BubbleEntitySorter<T> implements EntitySorter {
    private final Comparator<T> comparator;

    public BubbleEntitySorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> BubbleEntitySorter<T> naturalOrder() {
        return new BubbleEntitySorter<>((Comparator<T>) Comparator.naturalOrder());
    }

    @Override
    @SuppressWarnings("unchecked")
    public EntityCollection sortEntities(EntityCollection entities) {
        if (entities == null || entities.size() < 2) {
            return entities;
        }

        int n = entities.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                T current = (T) entities.get(j);
                T next = (T) entities.get(j + 1);

                if (comparator.compare(current, next) > 0) {
                    entities.set(j, next);
                    entities.set(j + 1, current);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return entities;
    }
}