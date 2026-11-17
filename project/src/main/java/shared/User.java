package shared.implementations;

public class User {

    private String name;
    private String password;
    private String email;
    private int age;

    public User(UserBuilder builder){
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
        this.age = builder.age;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }

    public String toString(){
        return "Имя: " + name + ". Пароль: " + password + ". Почта: " + email + ". Возраст: " + age;
    }

    public static class UserBuilder{
        public String name;
        public String password;
        public String email;
        public int age;

        public UserBuilder setName(String name) {this.name = name; return this;}
        public UserBuilder setPassword(String password) {this.password = password;return this;}
        public UserBuilder setEmail(String email) {this.email = email;return this;}
        public UserBuilder setAge(int age) {this.age = age;return this;}

        public User build(){
            return new User(this);
        }
    }
}

