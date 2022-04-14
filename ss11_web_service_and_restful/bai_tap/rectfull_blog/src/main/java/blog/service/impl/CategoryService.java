package blog.service.impl;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:55
*/

import blog.model.Category;
import blog.repository.ICategoryRepository;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        iCategoryRepository.deleteById(id);
    }
}
