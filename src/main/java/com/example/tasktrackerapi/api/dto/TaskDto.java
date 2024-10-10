package com.example.tasktrackerapi.api.dto;

import com.example.tasktrackerapi.store.entities.ProjectEntity;
import com.example.tasktrackerapi.store.entities.TaskEntity;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class TaskDto {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createdAt;
    @NonNull
    private String description;

    public TaskDto makeTaskDto(TaskEntity taskEntity){
        return TaskDto.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .createdAt(taskEntity.getCreatedAt())
                .description(taskEntity.getDescription())
                .build();
    }
}
