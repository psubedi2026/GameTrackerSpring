package com.theironyard.novauc;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by psubedi2020 on 3/16/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByName(String userName);
}
