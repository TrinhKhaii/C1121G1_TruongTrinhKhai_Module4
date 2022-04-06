package blog.model;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 05/04/2022
    Time: 10:59
*/
@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    private String blogAuthor;
    private String blogContent;
    @Column(columnDefinition = "datetime")
    private String createDate;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer blogId, String blogAuthor, String blogContent, String createDate, Category category) {
        this.blogId = blogId;
        this.blogAuthor = blogAuthor;
        this.blogContent = blogContent;
        this.createDate = createDate;
        this.category = category;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
