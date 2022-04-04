package music_app.service;
/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 21:05
*/

import music_app.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(Integer id);

    void save(Music music);

    void delete(Integer id);
}
