package com.kana.recipe.controller;

import com.kana.recipe.repositories.CategoryRepository;
import com.kana.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    private CategoryRepository categoryRepository;

    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}
