package com.dlflix.controller;

import com.dlflix.entity.Category;
import com.dlflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dlflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getByCategoryID(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.findById(id);

        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteByCategoryID(@PathVariable Long id){
        categoryService.deleteByCategoryId(id);
    }

}
