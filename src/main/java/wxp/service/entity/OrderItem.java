package wxp.service.entity;

public class OrderItem {
    private String name;
    private String practice;
    private int num;
    private double totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "name='" + name + '\'' +
                ", practice='" + practice + '\'' +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
