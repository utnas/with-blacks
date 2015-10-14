package com.withblacks.api.repository;

import com.withblacks.api.business.entities.user.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLastName(final String lastName);
}