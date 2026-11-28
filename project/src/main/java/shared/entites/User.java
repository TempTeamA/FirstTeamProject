package shared.entites;

import shared.entites.abstractions.Entity;

public class User extends Entity {
    private String name;
    private String email;
    private String password;
    private int age;

    public User(String name, String password, String email, int age) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    
    @Override
    public int compareTo(Entity other) {
        int base = super.compareTo(other);   
        if (base != 0) return base;          
        
        if (!(other instanceof User user)) { return 0; }

        int byName = this.name.compareTo(user.getName());
        if (byName != 0) return byName;

        int byEmail = this.email.compareTo(user.getEmail());
        if (byEmail != 0) return byEmail;

        int byPassword = this.password.compareTo(user.getPassword());
        if (byPassword != 0) return byPassword;

        return Integer.compare(this.age, user.getAge());
    }
}
