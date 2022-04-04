package music_app.repository;
/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 20:13
*/

import music_app.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    Music findById(Integer id);

    void save(Music music);

    void delete(Integer id);
}
