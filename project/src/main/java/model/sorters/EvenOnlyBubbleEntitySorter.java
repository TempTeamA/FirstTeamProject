package model.sorters;

import model.abstractions.EntitySorter;
import shared.entites.Bus;
import shared.entites.Car;
import shared.entites.User;
import shared.entites.abstractions.Entity;
import shared.entites.abstractions.EntityCollection;
import shared.logging.abstractions.Level;
import shared.logging.abstractions.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class EvenOnlyBubbleEntitySorter extends EntitySorter {

    private final Logger logger;

    public EvenOnlyBubbleEntitySorter(Comparator<Entity> comparator, Logger logger) {
        super(comparator);
        this.logger = logger;
    }

    @Override
    public EntityCollection sortEntities(EntityCollection entities) {

        List<Entity> list = entities.getEntityList();
        int n = list.size();
        int[] evenIndices = new int[n];
        int evenCount = 0;

        for (int i = 0; i < n; i++) {
            OptionalInt value = extractNumericField(list.get(i));
            if (value.isPresent() && value.getAsInt() % 2 == 0) {
                evenIndices[evenCount++] = i;
            }
        }

        boolean swapped;
        for (int i = 0; i < evenCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < evenCount - 1 - i; j++) {
                int idx1 = evenIndices[j];
                int idx2 = evenIndices[j + 1];

                Entity item1 = list.get(idx1);
                Entity item2 = list.get(idx2);

                int val1 = extractNumericField(item1).orElse(0);
                int val2 = extractNumericField(item2).orElse(0);

                if (Integer.compare(val1, val2) > 0) {
                    list.set(idx1, item2);
                    list.set(idx2, item1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        log(Level.INFO, "Отсортировано (только чётные значения)");
        return entities;
    }

    private OptionalInt extractNumericField(Entity entity) {
        if (entity instanceof Car car) {
            return OptionalInt.of(car.getEnginePower());
        }
        if (entity instanceof Bus bus) {
            return OptionalInt.of(bus.getMileage());
        }
        if (entity instanceof User user) {
            return OptionalInt.of(user.getAge());
        }
        return OptionalInt.empty();
    }

    private void log(Level level, String message) {
        if (logger != null) {
            logger.log(level, message);
        }
    }
}
