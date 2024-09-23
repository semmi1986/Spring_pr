package project.people.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class User {
    private int id;
    private String name;
    private String lastName;
    private int age;

    public User() {
    }

    public User(int id, String name,  String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
