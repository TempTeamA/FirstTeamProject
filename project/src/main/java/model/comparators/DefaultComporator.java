package model.comparators;

import shared.entites.abstractions.Entity;

import java.util.Comparator;

public class DefaultComporator implements Comparator<Entity> {

    @Override
    public int compare(Entity first, Entity second) {
        if (first == second) {
            return 0;
        }
        if (first == null) {
            return -1;
        }
        return first.compareTo(second);
    }
}
