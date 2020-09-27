package org.de;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Some Rhapsody";
    }

    public void doMyInit() {
        System.out.println("Doing my initialisation");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
}
