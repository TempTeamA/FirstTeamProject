package model.builders;

import model.abstractions.EntitySorter;
import model.abstractions.SorterBuilder;
import model.comparators.DefaultComparator;
import model.comparators.EvenNumericFieldComparator;
import model.sorters.BubbleEntitySorter;
import shared.entites.abstractions.Entity;
import shared.logging.abstractions.Logger;

import java.util.Comparator;

public class BubbleSorterBuilder implements SorterBuilder {

    private final Logger logger;
    private Comparator<Entity> comparator;

    public BubbleSorterBuilder(Logger logger) {
        this.logger = logger;
        this.comparator = new DefaultComparator();
    }

    @Override
    public SorterBuilder setDefaultComporator() {
        this.comparator = new DefaultComparator();
        return this;
    }

    @Override
    public SorterBuilder setAlternativeComporator() {
        this.comparator = new EvenNumericFieldComparator();
        return this;
    }

    @Override
    public EntitySorter build() {
        return new BubbleEntitySorter(comparator, logger);
    }
}

// rpath://project/src/main/java/model/builders/BubbleSorterBuilder.java
