package feedback.service;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 20:36
*/

import feedback.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();

    void save(Feedback feedback);

    void increateCommentLike(Feedback feedback);

    Feedback findById(int id);
}
