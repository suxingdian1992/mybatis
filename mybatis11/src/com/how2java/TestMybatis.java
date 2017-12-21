package com.how2java;
  
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
  
public class TestMybatis {
    public static void main(String[] args) throws IOException, InterruptedException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
     /*��ѯ�����֮ǰ�趨��ҳ�ı�ǣ��˴�Ϊ��ѯ0��5��*/
        /*PageHelper.offsetPage(0, 5);*/

       /* List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }*/
        /*��xml��������100������*/
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            session.delete("deleteCategory", c.getId());
        }
        for (int i = 0; i < 100; i++) {
            Category c = new Category();
            c.setName("category name " + i);
            session.insert("addCategory", c);
        }
        List<Category> cs2 = session.selectList("listCategory");
        for (Category c : cs2) {
            System.out.println(c.getName());
        }
        
        PageInfo pageInfo = new PageInfo<>(cs2);
        System.out.println("������"+pageInfo.getTotal());
        System.out.println(pageInfo);
        
        session.commit();
        session.close();
    }
}