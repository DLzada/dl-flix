package com.dlflix.mapper;

import com.dlflix.controller.request.MovieRequest;
import com.dlflix.controller.response.CategoryResponse;
import com.dlflix.controller.response.MovieResponse;
import com.dlflix.controller.response.StreamingResponse;
import com.dlflix.entity.Category;
import com.dlflix.entity.Movie;
import com.dlflix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request){

        List<Category> categories = request.categories() != null
                ? request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList()
                : List.of();

        List<Streaming> streamings = request.streamings() != null
                ? request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList()
                : List.of();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
