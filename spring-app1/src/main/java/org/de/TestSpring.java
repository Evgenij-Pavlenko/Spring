package org.de;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);
//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

//        ClassicalMusic classicalMusik2 = context.getBean("classicalMusic", ClassicalMusic.class);
//        ClassicalMusic classicalMusik3 = context.getBean("classicalMusic", ClassicalMusic.class);
//        System.out.println(classicalMusik.getSong());
//        System.out.println(classicalMusik2.getSong());
//        System.out.println(classicalMusik.getSong());
//        Music rockMusik = context.getBean("rockMusic", RockMusic.class);
//        System.out.println(rockMusik.getSong());
//        musicPlayer.playMusic();
//        boolean comparation = firstMusicPlayer == secondMusicPlayer;
//
//        System.out.println(comparation);
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(20);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());
        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);
        context.close();
    }
}
