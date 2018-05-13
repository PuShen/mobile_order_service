package wxp.service.entity;

public class Food {
    private String id;
    private String name;
    private String imageUrl;
    private String practice;
    private String description;
    private double price;
    private int number;
    private String labelId;
    private String restaurant;
    private int vareCount;

    public int getVareCount() {
        return vareCount;
    }

    public void setVareCount(int vareCount) {
        this.vareCount = vareCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", practice='" + practice + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", labelId='" + labelId + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", vareCount=" + vareCount +
                '}';
    }
}
