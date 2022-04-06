package blog.service.impl;
/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 13:42
*/

import blog.model.Category;
import blog.repository.ICategoryRepository;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        iCategoryRepository.deleteById(id);
    }
}
