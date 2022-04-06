package blog.model;

import javax.persistence.*;
import java.util.List;

/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 11:26
*/
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, List<Blog> blogs) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
