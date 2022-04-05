package feedback.service.impl;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 20:37
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feedback.model.Feedback;
import feedback.repository.IFeedbackRepository;
import feedback.service.IFeedbackService;

import java.util.List;
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository iFeedbackRepository;

    @Override
    public List<Feedback> findAll() {
        return iFeedbackRepository.findAll();
    }

    @Override
    public void save(Feedback feedback) {
        iFeedbackRepository.save(feedback);
    }

    @Override
    public void increateCommentLike(Feedback feedback) {
        feedback.setLikeNumber(feedback.getLikeNumber() + 1);
        iFeedbackRepository.save(feedback);
    }

    @Override
    public Feedback findById(int id) {
        return iFeedbackRepository.findById(id).orElse(null);
    }
}
