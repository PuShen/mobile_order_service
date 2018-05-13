package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.Food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FoodDAO {
    private final SqlSession sqlSession;

    public FoodDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public long getFoodNum(){
        long num=sqlSession.selectOne("food.selectCount");
        return num;
    }

    public List<Food> getFoodList(){
        List<Food> result=sqlSession.selectList("food.foodShow");
        return result;
    }

    public List<Food> getFoodOfId(List<String> list){
        List<Food> result=sqlSession.selectList("food.foodOfId",list);
        return result;
    }

    public List<Food> getFoodById(String id){
        List<Food> result=sqlSession.selectList("food.selectFoodById",id);
        return result;
    }

    public List<Food> getFoodOfPage(int startNum,int endNum){
        Map<String,Integer> resultMap=new HashMap<>();
        resultMap.put("startNum", Integer.valueOf(startNum));
        resultMap.put("endNum",Integer.valueOf(endNum));
        List<Food> result=sqlSession.selectList("food.foodOfPage",resultMap);
        return result;
    }

    public List<Food> getFood(String labelId,int startNum,int endNum){
        Map<String,Object> map=new HashMap<>();
        map.put("labelId",labelId);
        map.put("startNum",startNum);
        map.put("endNum",endNum);
        List<Food> result=sqlSession.selectList("food.selectFood",map);
        return result;
    }

    public int insertFood(Food food){
        return sqlSession.insert("food.insertFood",food);
    }

    public int deleteFood(String id){
        return sqlSession.delete("food.deleteFood",id);
    }

    public int updateFood(Food food){
        return sqlSession.update("food.updateFood",food);
    }

    public int updateFoodNum(String id,int number){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("number",number);
        return sqlSession.update("food.updateFoodNum",map);
    }
}
