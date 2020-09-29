package org.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    //    @Autowired
//    @Qualifier("classicalMusic")
    private Music music1;
    private Music music2;
    //    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;
    private List<Music> musicList;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

//    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public MusicPlayer() {
    }

    //    public Music getMusic() {
//        return music;
//    }
////@Autowired
//    public void fvfv(Music music) {
//        this.music = music;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
//
//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
    Random rnd = new Random();

    public String playMusic(Enum e) {
        if (e == MusicGenre.CLASSICAL) {
            return "Playing: " + music1.getSong().get(rnd.nextInt(3));
        }
        return "Playing: " + music2.getSong().get(rnd.nextInt(3));
    }
}
