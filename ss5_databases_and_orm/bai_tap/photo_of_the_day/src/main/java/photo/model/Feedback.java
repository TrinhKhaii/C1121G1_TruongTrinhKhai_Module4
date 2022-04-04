package photo.model;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 15:44
*/
@Entity(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rate;
    @Column(name = "author_name")
    private String authorName;
    private String feedback;
    @Column(name = "like_number")
    private Integer likeNumber;
    @Column(name = "commen_day", columnDefinition = "date")
    private String commentDay;

    public Feedback() {
    }

    public Feedback(Integer id, Integer rate, String authorName, String feedback, Integer likeNumber, String commentDay) {
        this.id = id;
        this.rate = rate;
        this.authorName = authorName;
        this.feedback = feedback;
        this.likeNumber = likeNumber;
        this.commentDay = commentDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getCommentDay() {
        return commentDay;
    }

    public void setCommentDay(String commentDay) {
        this.commentDay = commentDay;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", rate=" + rate +
                ", authorName='" + authorName + '\'' +
                ", feedback='" + feedback + '\'' +
                ", likeNumber=" + likeNumber +
                ", commentDay='" + commentDay + '\'' +
                '}';
    }
}
