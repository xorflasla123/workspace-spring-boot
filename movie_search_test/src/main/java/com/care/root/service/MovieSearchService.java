package com.care.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.care.root.dao.MovieSearchDao;
import com.care.root.dto.SearchMovieDto;
import com.care.root.movieURL.MovieURL;

@Service
public class MovieSearchService implements MovieURL{
	@Autowired
	MovieSearchDao dao;

	public List<SearchMovieDto> getMovies() {
		List<SearchMovieDto> list = dao.getMovies();
		for (SearchMovieDto dto : list) {
			Link link = Link.of(movieViewUrl + "movieinfo/" + dto.getMovieId());
			dto.add(link.withRel("movie"));
		}
		return list;
	}

}
