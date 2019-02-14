package com.pack.repository;

import com.pack.entity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEntity,String> {
    UserEntity findByUserId(String userId);
}
