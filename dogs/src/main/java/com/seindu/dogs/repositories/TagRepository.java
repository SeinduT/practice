package com.seindu.dogs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seindu.dogs.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

}
