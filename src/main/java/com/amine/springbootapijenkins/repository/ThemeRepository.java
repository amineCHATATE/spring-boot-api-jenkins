package com.amine.springbootapijenkins.repository;

import com.amine.springbootapijenkins.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
    List<Theme> findByName(String name);
}
