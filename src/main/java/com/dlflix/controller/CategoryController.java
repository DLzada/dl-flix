package com.dlflix.controller;

import com.dlflix.controller.request.CategoryRequest;
import com.dlflix.controller.response.CategoryResponse;
import com.dlflix.entity.Category;
import com.dlflix.mapper.CategoryMapper;
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
    public List<CategoryResponse> getAllCategory(){
        List<Category> categories = categoryService.findAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @PostMapping
    public CategoryResponse saveCategory(@RequestBody CategoryRequest categoryRequest){
        Category newCategory = CategoryMapper.toCategory(categoryRequest);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getByCategoryID(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.findById(id);

        if (optionalCategory.isPresent()){
            return CategoryMapper.toCategoryResponse(optionalCategory.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteByCategoryID(@PathVariable Long id){
        categoryService.deleteByCategoryId(id);
    }

}
