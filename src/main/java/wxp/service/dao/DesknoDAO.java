package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.Desk;
import wxp.service.entity.Food;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DesknoDAO {
    private final SqlSession sqlSession;

    public DesknoDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public long getDesknoNum(){
        long num=sqlSession.selectOne("deskno.selectCount");
        return num;
    }

    public List<Food> getDesknoOfPage(int startNum,int endNum){
        Map<String,Integer> resultMap=new HashMap<>();
        resultMap.put("startNum", Integer.valueOf(startNum));
        resultMap.put("endNum",Integer.valueOf(endNum));
        List<Food> result=sqlSession.selectList("deskno.desknoOfPage",resultMap);
        return result;
    }

    public List<Desk> getDesknoList(){
        List<Desk> result=sqlSession.selectList("deskno.desknoShow");
        return result;
    }

    public int insertDeskno(Desk desk){
        return sqlSession.insert("deskno.insertDeskno",desk);
    }

    public int deleteDeskno(String no){
        return sqlSession.delete("deskno.deleteDeskno",no);
    }
}
