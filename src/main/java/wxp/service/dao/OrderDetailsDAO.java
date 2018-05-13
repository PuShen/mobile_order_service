package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.OrderDetails;
import wxp.service.entity.OrderItem;
import wxp.service.entity.OrderOverView;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderDetailsDAO {
    private final SqlSession sqlSession;

    public OrderDetailsDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public int insertOrderDetails(OrderDetails orderDetails){
        return sqlSession.insert("order_details.insertOrderDetails",orderDetails);
    }

    public long getOrderNum(){
        long num=sqlSession.selectOne("order_details.selectCount");
        return num;
    }

    public List<OrderOverView> selectOrder(int startNum, int endNum){
        List<OrderDetails> list=sqlSession.selectList("order_details.selectOrder");
        Map<String, Map<Date, List<OrderDetails>>> orders=list.stream().collect(Collectors.groupingBy(OrderDetails::getNo,Collectors.groupingBy(OrderDetails::getTime)));
        List<OrderOverView> orderOverViews=new ArrayList<>();
        orders.forEach((no,v1)->{
            v1.forEach((time,v2)->{
                OrderOverView orderOverView=new OrderOverView();
                orderOverView.setNo(no);
                orderOverView.setTime(time);
                orderOverView.setRestaurant(v2.get(0).getRestaurant());
                orderOverView.setTotalPrice(v2.stream().map(OrderDetails::getTotalPrice).reduce((a, b)->a+b).get());
                orderOverView.setOrderItems(v2.stream().map(data->{
                    OrderItem item=new OrderItem();
                    item.setName(data.getName());
                    item.setNum(data.getNum());
                    item.setPractice(data.getPractice());
                    item.setTotalPrice(data.getTotalPrice());
                    return item;
                }).collect(Collectors.toList()).toArray(new OrderItem[v2.size()]));
                orderOverViews.add(orderOverView);
            });
        });
        return orderOverViews.stream().skip(startNum).limit(endNum).collect(Collectors.toList());
    }
}
