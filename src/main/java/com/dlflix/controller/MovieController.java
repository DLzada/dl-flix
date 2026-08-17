package com.dlflix.controller;

import com.dlflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dlflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

}
