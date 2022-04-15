package blog.service.impl;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:51
*/

import blog.model.Blog;
import blog.repository.IBlogRepository;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(Integer id) {
        return iBlogRepository.findAllByCategory_CategoryId(id);
    }

    @Override
    public Page<Blog> findAllByBlogAuthorContaining(String author, Pageable pageable) {
        return iBlogRepository.findAllByBlogAuthorContaining(author, pageable);
    }
}
