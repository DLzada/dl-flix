package com.dlflix.repository;

import com.dlflix.entity.Category;
import com.dlflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMovieByCategories_IdIn(List<Long> categoryIds);
}
