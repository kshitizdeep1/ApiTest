package com.omnicell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnicell.entity.Recipe;
import com.omnicell.service.RecipeService;

@CrossOrigin
@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	Recipe recipe;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
		recipe = recipeService.getRecipeById(id);
		if (recipe == null) {
			return new ResponseEntity<Recipe>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}

	@GetMapping(value = "{id}/show", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getRecipeImageById(@PathVariable("id") Long id) {
		recipe = recipeService.getImageByID(id);
		if(recipe==null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(recipe.getImage(), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
		Recipe newrecipe = recipeService.addRecipe(recipe);
		return new ResponseEntity<Recipe>(newrecipe, HttpStatus.OK);
	}
	@PutMapping(value="/edit/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> editRecipe(@RequestBody Recipe newRecipe,@PathVariable("id") Long id) {
		recipe=recipeService.getRecipeById(id);
		recipe.setImage(newRecipe.getImage());
		recipe.setCategory(newRecipe.getCategory());
		recipe.setLabel(newRecipe.getLabel());
		recipe.setName(newRecipe.getName());
		recipe.setPrice(newRecipe.getPrice());
		recipe.setDescription(newRecipe.getDescription());
		recipeService.updateRecipe(recipe);
		return new ResponseEntity<Recipe>(recipe,HttpStatus.OK);		
	}
	@DeleteMapping(value="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long id){
		recipeService.deleteRecipeById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
}
