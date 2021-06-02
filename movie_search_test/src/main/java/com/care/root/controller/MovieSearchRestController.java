package com.care.root.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.SearchMovieDto;
import com.care.root.service.MovieSearchService;

@RestController
@RequestMapping("search")
@CrossOrigin
public class MovieSearchRestController {
	@Autowired
	MovieSearchService ms;
	@GetMapping("getMovies")
	public List<SearchMovieDto> getMovies() {
		return ms.getMovies();
	}
	@GetMapping("movieinfo/{movieId}")
	public SearchMovieDto movieInfo(@PathVariable String movieId) {
		return ms.getMovieInfo(movieId);
	}
	@PutMapping("subCount")
	public void subCount(@RequestBody Map map) {
		ms.subCount(map);
	}
	@GetMapping("getCount/{movieId}")
	public Integer getCount(@PathVariable Integer movieId) {
		return ms.getCount(movieId);
	}
}





