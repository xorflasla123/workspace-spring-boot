package com.care.root.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.care.root.dto.TestDto;

public interface TestDao {
	@Select("select * from member") 
	public ArrayList<TestDto> getMembers();
	@Select("select * from member where id=#{id}")
	public TestDto getMember(int id);
	@Insert("insert into member values(member_seq.nextval, #{name}, #{age})")
	public void save(TestDto dto);
	
	@Delete("delete from member where id=#{id}")
	public void delete(int id);
	@Update("update member set name=#{name}, age=#{age} where id=#{id}")
	public void modify(TestDto dto);
}




