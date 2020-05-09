package pl.codelearn.JoinTheFootprints.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.repository.ExcursionRepository;
import pl.codelearn.JoinTheFootprints.repository.PaginationExcursionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationExcursionService implements PageService {

    private PaginationExcursionRepository paginationExcursionRepository;
    private ExcursionRepository excursionRepository;

    @Autowired
    public PaginationExcursionService(PaginationExcursionRepository paginationExcursionRepository, ExcursionRepository excursionRepository) {
        this.paginationExcursionRepository = paginationExcursionRepository;
        this.excursionRepository = excursionRepository;
    }

    public List<Excursion> getAllExcursions(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("dateOfDeparture").descending());

        Page<Excursion> pageResult = paginationExcursionRepository.findAll(paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else return new ArrayList<Excursion>();
    }

    @Override
    public Integer getPagesNumber() {
        return paginationExcursionRepository.pagesNumber();
    }
}
