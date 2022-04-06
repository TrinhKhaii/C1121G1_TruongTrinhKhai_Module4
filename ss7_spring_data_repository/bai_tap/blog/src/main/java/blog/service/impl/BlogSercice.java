package blog.service.impl;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:42
*/

import blog.model.Blog;
import blog.repository.IBlogRepository;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSercice implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return iBlogRepository.findAllByOrderByCreateDate(pageable);
    }

    @Override
    public Page<Blog> findBlogByName(String keyword, Pageable pageable) {
        return iBlogRepository.findAllByBlogAuthorContainingOrderByCreateDate(keyword, pageable);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
