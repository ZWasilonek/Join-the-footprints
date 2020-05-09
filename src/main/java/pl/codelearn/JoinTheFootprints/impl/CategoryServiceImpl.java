package pl.codelearn.JoinTheFootprints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codelearn.JoinTheFootprints.impl.generic.GenericServiceImpl;
import pl.codelearn.JoinTheFootprints.model.Category;
import pl.codelearn.JoinTheFootprints.repository.CategoryRepository;
import pl.codelearn.JoinTheFootprints.service.CategoryService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryRepository> implements CategoryService<Category> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryRepository categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Long> availableCategoriesId() {
        return categoryRepository.getAllAvailableCategoriesId();
    }

//    @Override
//    public List<Category> findAll() {
//        return categoryRepository.findAll();
//    }

    public List<Category> getAvailableCategories() {
        return availableCategoriesId().stream()
                .map(id -> categoryRepository.findById(id).orElse(null))
                .collect(Collectors.toList());
    }

}
