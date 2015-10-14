package com.withblacks.api.repository;

import com.withblacks.api.business.entities.project.Project;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByName(final String name);
}
