package com.omnicell.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicell.entity.Recipe;
import com.omnicell.service.RecipeService;

@Component
public class UrlLoadRunner implements CommandLineRunner {

	@Autowired
	RecipeService recipeService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		ObjectMapper objectMapper=new ObjectMapper();
		System.out.println("UrlLoading");
		List<Recipe> recipes = restTemplate.getForObject(
				"https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json", ArrayList.class);
		List<Recipe> recipeList = objectMapper.convertValue(recipes, new TypeReference<List<Recipe>>() {
		});
		recipeService.addAll(recipeList);
		System.out.println("recipie added");
	}

}
