package wxp.service.entity;

import java.util.Date;

public class OrderDetails {
    private String name;
    private String no;
    private String practice;
    private int num;
    private double totalPrice;
    private Date time;
    private String restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", practice='" + practice + '\'' +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                ", time=" + time +
                ", restaurant='" + restaurant + '\'' +
                '}';
    }
}
