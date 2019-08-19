package mybatis;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable{

    // 商品id，主键
    private Integer id;

    // 商品名称
    private String name;

    // 商品价格
    private Double price;

    // 商品描述
    private String rematk;

    // 商品和订单是多对多的关系，即一种商品可以出现在多个订单中
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRematk() {
        return rematk;
    }

    public void setRematk(String rematk) {
        this.rematk = rematk;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String toString()
    {
        return "Article [id=" + id + ", name=" + name + ", price=" + price + ", rematk=" + rematk + "]";
    }
}
