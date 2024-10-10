package com.example.tasktrackerapi.store.repositories;

import com.example.tasktrackerapi.api.dto.ProjectDto;
import com.example.tasktrackerapi.store.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByName(String name);


}
