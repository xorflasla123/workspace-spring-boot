package com.care.root.service;

import java.util.ArrayList;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.care.root.dto.SearchMovieDto;

@Service
public class SearchService {

	public ArrayList<SearchMovieDto> getMovieView() {
		ArrayList<SearchMovieDto> list = new ArrayList<SearchMovieDto>();
		String movieURL = "http://localhost:10000/search/movieinfo/";
		for (int i = 1; i < 6; i++) {
			SearchMovieDto dto = new SearchMovieDto();
			dto.setMovieId(i + "");
			dto.setMovieTitle("화성을 지켜라" + i);
			dto.setMovieDate("2200-05-1" + i);
			Link link = Link.of(movieURL + i);
			dto.add(link.withRel(dto.getMovieTitle()));// 경로이름
			list.add(dto);
		}
		return list;
	}

}
