package com.omnicell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnicell.entity.Recipe;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
