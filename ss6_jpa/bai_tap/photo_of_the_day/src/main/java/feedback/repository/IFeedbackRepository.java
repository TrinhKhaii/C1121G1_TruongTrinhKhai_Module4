package feedback.repository;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 15:45
*/

import feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
}
