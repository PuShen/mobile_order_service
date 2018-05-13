package wxp.service.entity;

import java.util.Arrays;

public class Order {
    private String position;
    private Food[] orderData;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Food[] getOrderData() {
        return orderData;
    }

    public void setOrderData(Food[] orderData) {
        this.orderData = orderData;
    }

    @Override
    public String toString() {
        return "Order{" +
                "position='" + position + '\'' +
                ", orderData=" + Arrays.toString(orderData) +
                '}';
    }
}
