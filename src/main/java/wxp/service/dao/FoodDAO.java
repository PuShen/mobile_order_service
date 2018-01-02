package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.Food;

import java.util.HashMap;
import java.util.List;

@Component
public class FoodDAO {
    private final SqlSession sqlSession;

    public FoodDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public List<Food> getFoodList(){
        List<Food> result=sqlSession.selectList("food.foodShow");
        return result;
    }

    public int insertFood(Food food){
        return sqlSession.insert("food.insertFood",food);
    }
}
