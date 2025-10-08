package org.example.people;

public class BasePerson {

    private String uuid;

    private String firstName;
    private String lastName;

    public BasePerson(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getName() { return firstName; }
    public String getLastName() {
        return lastName;
    }
}
