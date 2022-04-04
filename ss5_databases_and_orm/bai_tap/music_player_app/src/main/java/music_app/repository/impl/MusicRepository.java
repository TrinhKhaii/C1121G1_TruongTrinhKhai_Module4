package music_app.repository.impl;
/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 20:46
*/

import music_app.model.Music;
import music_app.repository.IMusicRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_ALL = "select m from music m";
    private static final String FIND_BY_ID = "select m from music as m WHERE m.id = :id";

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = entityManager.createQuery(FIND_ALL, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(Integer id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void delete(Integer id) {

    }
}
