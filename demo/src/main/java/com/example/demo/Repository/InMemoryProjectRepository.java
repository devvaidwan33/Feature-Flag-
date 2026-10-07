package com.example.demo.Repository;

import com.example.demo.Model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {
     private final Map<UUID,Project> store = new ConcurrentHashMap<>();
     @Override
    public Project save (Project project){
        store.put(project.getId(), project);
        return project;
    }
    @Override
    public Optional<Project> findById(UUID id){
        return Optional.ofNullable(store.get(id));
     }
     @Override
    public List<Project> findByOrganisationId(UUID organisationId){
        return store.values().stream().
                filter(project -> project.getOrganisationId().equals(organisationId)).
                toList();
     }
     // we find all project of a given organisation id ... so we filter all the project having project.getOrganisationid
    // equal to given(user given) organisation id
    // if equal then project retrun otherwise 404 error;

}
