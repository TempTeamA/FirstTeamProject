package model.sorters;

import model.abstractions.EntitySorter;
import shared.entites.abstractions.Entity;
import shared.entites.abstractions.EntityCollection;
import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;

import java.util.Comparator;
import java.util.List;

public class BubbleEntitySorter extends EntitySorter {

    private final Logger logger;

    public BubbleEntitySorter(Comparator<Entity> comparator, Logger logger) {
        super(comparator);
        this.logger = logger;
    }

    @Override
    public EntityCollection sortEntities(EntityCollection entities) {

        List<Entity> list = entities.getEntityList();
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

        log(Level.INFO, "Отсортировано");
        return entities;
    }

    private void log(Level level, String message) {
        if (logger != null) {
            logger.log(level, message);
        }
    }
}
