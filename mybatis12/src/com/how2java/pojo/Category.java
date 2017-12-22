package com.how2java.pojo;
 
import java.io.Serializable;
import java.util.List;
 

/**
 * @author suxin
 * 2017年12月22日
 * prjName:mybatis12 pakName:com.how2java.pojo
 * TODO
 * 为了放在二级缓存上，需要实现序列化的接口
 * 2017年12月22日
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