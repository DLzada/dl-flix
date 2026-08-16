package com.dlflix.mapper;

import com.dlflix.controller.request.CategoryRequest;
import com.dlflix.controller.response.CategoryResponse;
import com.dlflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
