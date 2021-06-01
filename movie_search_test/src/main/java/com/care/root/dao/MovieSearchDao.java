package com.care.root.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.care.root.dto.SearchMovieDto;

public interface MovieSearchDao {
	@Results({ 
			@Result(property = "movieId", column = "movie_id"),
			@Result(property = "movieTitle", column = "movie_title"),
			@Result(property = "movieDate", column = "movie_date"),
			@Result(property = "count", column = "count") })
	@Select("select * from movie_playing")
	public List<SearchMovieDto> getMovies();
}
