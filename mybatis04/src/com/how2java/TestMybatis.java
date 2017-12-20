package com.how2java;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Product;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
        	//多对一属性，注意配置文件中加入的两个mapper，注意对比前面的1对多
			System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
		}

        session.commit();
        session.close();
 
    }
}