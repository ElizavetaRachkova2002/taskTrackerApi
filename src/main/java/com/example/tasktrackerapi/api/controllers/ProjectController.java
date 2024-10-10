package com.example.tasktrackerapi.api.controllers;

import com.example.tasktrackerapi.api.dto.ProjectDto;
import com.example.tasktrackerapi.store.entities.ProjectEntity;
import com.example.tasktrackerapi.store.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@RequiredArgsConstructor
/**
 * Можем создавать, обновлять, удалть и получать список проектов
 */
public class ProjectController {
    private final ProjectDto projectDto;
    private final ProjectRepository projectRepository;


    public static final String CREATE_PROJECT = "/api/projects";
    public static final String EDIT_PROJECT = "/api/projects/{project_id}";
    public static final String DELETE_PROJECT = "/api/projects/{project_id}";
    public static final String GET_PROJECT = "/api/projects/list";


    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {
        ProjectEntity projectEntity = projectRepository.saveAndFlush(
                ProjectEntity.builder()
                        .name(name)
                        .build());
        return projectDto.makeProjectDto(projectEntity);
    }

    @PatchMapping(EDIT_PROJECT)
    public ResponseEntity<ProjectDto> editProject(@PathVariable Long project_id, @RequestParam String name) {
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(project_id);
        if (projectEntityOptional.isPresent()) {
            ProjectEntity projectEntity = projectEntityOptional.get();
            projectEntity.setName(name);
            projectRepository.saveAndFlush(projectEntity);
            return new ResponseEntity<>(projectDto.makeProjectDto(projectEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(DELETE_PROJECT)
    public HttpStatus deleteProject (@PathVariable Long project_id)
    {
        Optional<ProjectEntity> projectEntityForDelete = projectRepository.findById(project_id);
        if (projectEntityForDelete.isPresent())
        {
            ProjectEntity projectEntity = projectEntityForDelete.get();
            projectRepository.delete(projectEntity);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }


    @GetMapping(GET_PROJECT)
    public List<ProjectDto> getListProducts(){
        List<ProjectEntity> projectDtoList = projectRepository.findAll();
        return  projectDto.makeListProjectDto(projectDtoList);
    }

}
