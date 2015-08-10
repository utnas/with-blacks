package com.withblacks.repository.project;

import com.withblacks.business.entities.project.Project;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByName(final String name);
}
