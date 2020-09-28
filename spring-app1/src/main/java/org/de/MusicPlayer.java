package org.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicPlayer {
//    @Autowired
    private Music music;
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    private List<Music> musicList;
    private String name;
    private int volume;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//
//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong();
    }
}
