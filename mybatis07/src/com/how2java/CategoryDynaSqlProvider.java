package com.how2java;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author suxin
 * 2017年12月20日
 * prjName:mybatis07 pakName:com.how2java
 * TODO
 * 本类用来生成sql语句，学会使用sql（）语句生成格式化的sql语句
 * 2017年12月20日
 */
public class CategoryDynaSqlProvider {
	public String list() {
		 return new SQL()
				 .SELECT("*")
				 .FROM("category_")
				 .toString();
		
	}
	public String get() {
		return new SQL()
				.SELECT("*")
				.FROM("category_")
				.WHERE("id=#{id}")
				.toString();
	}
	
	
	public String add(){
		return new SQL()
				.INSERT_INTO("category_")
				.VALUES("name", "#{name}")
				.toString();
	}
	public String update(){
		return new SQL()
				.UPDATE("category_")
				.SET("name=#{name}")
				.WHERE("id=#{id}")
				.toString();
	}
	public String delete(){
		return new SQL()
				.DELETE_FROM("category_")
				.WHERE("id=#{id}")
				.toString();
	}
	
	
}