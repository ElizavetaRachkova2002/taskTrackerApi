package com.example.tasktrackerapi.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="project")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Builder.Default
    private Instant createdAt = Instant.now();
    @OneToMany
    @Builder.Default
    @JoinColumn (name="project_id", referencedColumnName = "id")
    private List<TaskEntity> taskStates  = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public List<TaskEntity> getTaskStates() {
        return taskStates;
    }

    public void setTaskStates(List<TaskEntity> taskStates) {
        this.taskStates = taskStates;
    }
}
