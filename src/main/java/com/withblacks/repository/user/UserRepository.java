package com.withblacks.repository.user;

import com.withblacks.business.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(final String lastName);
}