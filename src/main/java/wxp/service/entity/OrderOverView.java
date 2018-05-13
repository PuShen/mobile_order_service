package wxp.service.entity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class OrderOverView {
    private String no;
    private String time;
    private String restaurant;
    private double totalPrice;
    private OrderItem[] orderItems;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Date time) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        this.time=sdf.format(time);
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderOverView{" +
                "no='" + no + '\'' +
                ", time=" + time +
                ", restaurant='" + restaurant + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderItems=" + Arrays.toString(orderItems) +
                '}';
    }
}
