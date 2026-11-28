package model.abstractions;

public interface SorterBuilder {
    SorterBuilder setDefaultSorting();

    SorterBuilder setAlternativeSorting();

    EntitySorter build();
}
