package com.school.project.services;

import com.school.project.entities.Classe;

import java.util.List;

public interface ClasseService {
    Classe saveClasse(Classe classe);
    List<Classe> getAllClasse(int page, int size);
}
