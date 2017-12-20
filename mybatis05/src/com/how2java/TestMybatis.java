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
     * 下午3:30:38
     * Args:@param session
     * ReturnType:void
     * Author:suxin
     * TODO
     * 作业：删除订单，注意数据库连接配置加入了允许同时执行多条sql语句
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
			//注意，如果要在mysql中做精确计算，请使用decimal，如果是float或者double可能会造成精度损失，比如该例中商品价格本来是88.88但是在此处输出就造成了误差
			for (OrderItem oi : ois) {
				System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
			}
		}
	}
}