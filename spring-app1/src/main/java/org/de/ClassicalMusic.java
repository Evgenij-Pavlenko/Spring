package org.de;

public class ClassicalMusic implements Music {
    private ClassicalMusic(){}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

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
