package com.how2java;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
 
        //deleteOrderItem(session);
        addOrderItem(session);
        listOrder(session);

        session.commit();
        session.close();
 
    }
    
    /**
     * ����3:30:38
     * Args:@param session
     * ReturnType:void
     * Author:suxin
     * TODO
     * ��ҵ��ɾ��������ע�����ݿ��������ü���������ͬʱִ�ж���sql���
     */
    private static void deleteOrder(SqlSession session) {
		int id = 1;
		
		session.delete("deleteOrder",id);
		
	}

	private static void deleteOrderItem(SqlSession session) {
		Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        session.delete("deleteOrderItem", oi);		
	}

	private static void addOrderItem(SqlSession session) {
		Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);
        
        session.insert("addOrderItem", oi);
	}

	private static void listOrder(SqlSession session) {
		List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
			System.out.println(o.getCode());
			List<OrderItem> ois= o.getOrderItems();
			//ע�⣬���Ҫ��mysql������ȷ���㣬��ʹ��decimal�������float����double���ܻ���ɾ�����ʧ�������������Ʒ�۸�����88.88�����ڴ˴��������������
			for (OrderItem oi : ois) {
				System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
			}
		}
	}
}