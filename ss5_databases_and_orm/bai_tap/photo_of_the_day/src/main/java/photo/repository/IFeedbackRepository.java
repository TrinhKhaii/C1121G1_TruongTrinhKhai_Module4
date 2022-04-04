package photo.repository;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 15:45
*/

import photo.model.Feedback;

import java.util.List;

public interface IFeedbackRepository {
    List<Feedback> findAll();

    void save(Feedback feedback);

    void increateCommentLike(Feedback feedback);


    Feedback findById(int id);
}
