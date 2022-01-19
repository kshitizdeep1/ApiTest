package com.omnicell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnicell.entity.Recipe;
import com.omnicell.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;

	public Recipe getRecipeById(Long id) {
		return recipeRepository.findById(id).get();
	}

	public Recipe getImageByID(Long id) {
		return recipeRepository.findById(id).get();
	}

	public Recipe addRecipe(Recipe recipe) {
			return recipeRepository.save(recipe);
	}

	public void addAll(List<Recipe> recipeList) {
		recipeRepository.saveAll(recipeList);		
	}

	public void updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		recipeRepository.save(recipe);
		
	}

	public void deleteRecipeById(Long id) {
		// TODO Auto-generated method stub
		recipeRepository.deleteById(id);
	}


}
