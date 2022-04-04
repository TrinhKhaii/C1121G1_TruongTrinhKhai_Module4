package music_app.service.impl;
/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 21:04
*/

import music_app.model.Music;
import music_app.repository.IMusicRepository;
import music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(Integer id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void delete(Integer id) {
        iMusicRepository.delete(id);
    }
}
