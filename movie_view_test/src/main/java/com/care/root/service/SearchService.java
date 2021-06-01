package com.care.root.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.care.root.dto.SearchMovieDto;
import com.care.root.movieURL.MovieURL;

@Service
public class SearchService implements MovieURL{
	
	RestTemplate movieSearch = new RestTemplate();
	
	public SearchMovieDto[] getMovieView() {
		//movieViewUrl = "http://localhost:10001/search";
		return movieSearch.getForObject(movieViewUrl+"getMovies", SearchMovieDto[].class);
		
//		String test = movieSearch.getForObject(movieViewUrl+"getMovies", String.class);
//		System.out.println("result : "+test);
//		
//		ArrayList<SearchMovieDto> list = new ArrayList<SearchMovieDto>();
//		String movieURL = "http://localhost:10000/search/movieinfo/";
//		for (int i = 1; i < 6; i++) {
//			SearchMovieDto dto = new SearchMovieDto();
//			dto.setMovieId(i + "");
//			dto.setMovieTitle("화성을 지켜라" + i);
//			dto.setMovieDate("2200-05-1" + i);
//			Link link = Link.of(movieURL + i);
//			dto.add(link.withRel(dto.getMovieTitle()));// 경로이름
//			list.add(dto);
//		}
//		return list;
	}

}
