package com.how2java.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.how2java.CategoryDynaSqlProvider;
import com.how2java.pojo.Category;
 
/**
 * @author suxin
 * 2017年12月20日
 * prjName:mybatis07 pakName:com.how2java.mapper
 * TODO
 * 基于注解之后修正的增删改查语句使用例子
 * 2017年12月20日
 */
public interface CategoryMapper {
 
	
    @InsertProvider(type=CategoryDynaSqlProvider.class,method="add")  
    public int add(Category category);  
       
  
	@DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
    public void delete(int id);  
       
    @SelectProvider(type=CategoryDynaSqlProvider.class,method="get")  
    public Category get(int id);  
     
    @UpdateProvider(type=CategoryDynaSqlProvider.class,method="update")  
    public int update(Category category);   
       
    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")      
    public List<Category> list();  
}