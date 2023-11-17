package com.ssafy.course.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.course.model.Course;
import com.ssafy.course.model.Courseinfo;

@Mapper
public interface CourseMapper {
	int registCourse(Course course) throws SQLException;
	void registCourseinfo(Map<String, Object> map) throws SQLException;
}
