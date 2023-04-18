package com.school.project.services.impl;

import com.school.project.dao.ClasseRepository;
import com.school.project.entities.Classe;
import com.school.project.entities.School;
import com.school.project.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;
    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public List<Classe> getAllClasse(int page, int size) {
        List<School> schoolList;
        Pageable paging = PageRequest.of(page, size);
        Page<School> pageSchools;
        return null;
    }
}
