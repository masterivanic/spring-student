package com.school.project.dto;

import com.school.project.entities.Classe;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class SchoolDetailsDto {
    private Long id;
    private String schoolName;
    private String schoolLocation;
    private String schoolType;
    private List<Classe> classList;
}
