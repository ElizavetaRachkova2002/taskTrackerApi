package com.example.tasktrackerapi.api.dto;

import com.example.tasktrackerapi.store.entities.ProjectEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProjectDto {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createdAt;

    public ProjectDto makeProjectDto(ProjectEntity projectEntity){
        return ProjectDto.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .createdAt(projectEntity.getCreatedAt())
                .build();
    }


    public List<ProjectDto> makeListProjectDto(List<ProjectEntity> projectEntityList){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (ProjectEntity projectEntity: projectEntityList) {
            projectDtoList.add(ProjectDto.builder()
                    .id(projectEntity.getId())
                    .name(projectEntity.getName())
                    .createdAt(projectEntity.getCreatedAt())
                    .build());
        }
return projectDtoList;
    }

}
