package com.how2java.pojo;
 
import java.io.Serializable;
import java.util.List;
 

/**
 * @author suxin
 * 2017��12��22��
 * prjName:mybatis12 pakName:com.how2java.pojo
 * TODO
 * Ϊ�˷��ڶ��������ϣ���Ҫʵ�����л��Ľӿ�
 * 2017��12��22��
 */
public class Category implements Serializable{
    private int id;
    private String name;
    List<Product> products;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
     
}