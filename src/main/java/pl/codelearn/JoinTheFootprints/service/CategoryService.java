package pl.codelearn.JoinTheFootprints.service;

import pl.codelearn.JoinTheFootprints.service.generic.GenericService;
import java.util.Set;

public interface CategoryService<T> extends GenericService<T> {

    Set<Long> availableCategoriesId();

}
