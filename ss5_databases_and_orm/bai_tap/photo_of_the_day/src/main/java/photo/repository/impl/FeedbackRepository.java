package photo.repository.impl;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 15:45
*/

import org.springframework.stereotype.Repository;
import photo.model.Feedback;
import photo.repository.IFeedbackRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class FeedbackRepository implements IFeedbackRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String FIND_ALL = "select f from feedback f";

    @Override
    public List<Feedback> findAll() {
        TypedQuery<Feedback> typedQuery = entityManager.createQuery(FIND_ALL, Feedback.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
        entityManager.persist(feedback);
    }

    @Override
    public void increateCommentLike(Feedback feedback) {
        feedback.setLikeNumber(feedback.getLikeNumber() + 1);
        entityManager.merge(feedback);
    }

    @Override
    public Feedback findById(int id) {
        return entityManager.find(Feedback.class , id);
    }
}
