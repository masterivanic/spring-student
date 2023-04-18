package com.school.project.services.impl;

import com.school.project.dao.ClasseRepository;
import com.school.project.dao.SchoolRepository;
import com.school.project.entities.Classe;
import com.school.project.entities.School;
import com.school.project.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final ClasseRepository classeRepository;
    @Override
    public School saveSchool(School school) {
        return this.schoolRepository.save(school);
    }

    @Override
    public List<School> getSchoolList(int page, int size) {
        List<School> schoolList;
        Pageable paging = PageRequest.of(page, size);
        Page<School> pageSchools;
        pageSchools = this.schoolRepository.findAll(paging);
        schoolList = pageSchools.getContent();
        return  schoolList;
    }

    @Override
    public School getSchoolById(Long id) {
        Optional<School> school = this.schoolRepository.findById(id);
        if(school.isPresent())
            return school.get();
        return null;
    }

    @Override
    public void deleteSchool(Long id) {
        School school = this.getSchoolById(id);
        if(school != null)
            this.schoolRepository.delete(school);
    }

    @Override
    public void updateSchool(School school) {
        this.schoolRepository.save(school);
    }

    @Override
    public List<School> findBySchoolName(String schoolName) {
        return null;
    }

    @Override
    public List<Classe> getSchoolAndClass(long id) {
        List<Classe> classeList = classeRepository.findAll();
        classeList.stream()
                .filter(classe -> classe.getSchool().getId().equals(id))
                .collect(Collectors.toList());
        return classeList;
    }
}
