package com.example.tasktrackerapi.api.dto;


import com.example.tasktrackerapi.store.entities.TaskEntity;
import com.example.tasktrackerapi.store.entities.TaskStateEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class TaskStateDto {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createdAt;
    @NonNull
    private Long ordinal;

    public TaskStateDto makeTaskStateDto(TaskStateEntity taskStateEntity){
        return TaskStateDto.builder()
                .id(taskStateEntity.getId())
                .name(taskStateEntity.getName())
                .createdAt(taskStateEntity.getCreatedAt())
                .ordinal(taskStateEntity.getOrdinal())
                .build();
    }

}
