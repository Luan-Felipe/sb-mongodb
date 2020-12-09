package com.mongodb.mongod.repository;

import com.fasterxml.jackson.databind.node.POJONode;
import com.mongodb.mongod.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

}
