package music_app.model;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 20:08
*/
@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String singer;
    private String musicGenre;
    private String musicFilePath;

    public Music() {
    }

    public Music(Integer id, String name, String singer, String musicGenre, String musicFilePath) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.musicFilePath = musicFilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getMusicFilePath() {
        return musicFilePath;
    }

    public void setMusicFilePath(String musicFilePath) {
        this.musicFilePath = musicFilePath;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", musicGenre='" + musicGenre + '\'' +
                ", musicFilePath='" + musicFilePath + '\'' +
                '}';
    }
}
