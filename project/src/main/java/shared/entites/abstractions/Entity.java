package shared.entites.abstractions;

public class Entity implements Comparable<Entity>{
	@Override
    public int compareTo(Entity other) {
        return this.getClass().getName().compareTo(other.getClass().getName());
    }
}
