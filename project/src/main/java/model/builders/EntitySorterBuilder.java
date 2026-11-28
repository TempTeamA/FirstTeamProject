package model.builders;

import model.abstractions.EntitySorter;
import model.abstractions.SorterBuilder;
import model.comparators.DefaultComporator;
import model.sorters.BubbleEntitySorter;
import model.sorters.EvenOnlyBubbleEntitySorter;
import shared.entites.abstractions.Entity;
import shared.logging.abstractions.Logger;

import java.util.Comparator;

public class EntitySorterBuilder implements SorterBuilder {

    private final Logger logger;
    private final Comparator<Entity> comparator;
    private boolean alternativeMode;

    public EntitySorterBuilder(Logger logger) {
        this.logger = logger;
        this.comparator = new DefaultComporator();
        this.alternativeMode = false;
    }

    @Override
    public SorterBuilder setDefaultSorting() {
        this.alternativeMode = false;
        return this;
    }

    @Override
    public SorterBuilder setAlternativeSorting() {
        this.alternativeMode = true;
        return this;
    }

    @Override
    public EntitySorter build() {
        if (alternativeMode) {
            return new EvenOnlyBubbleEntitySorter(comparator, logger);
        }
        return new BubbleEntitySorter(comparator, logger);
    }
}
