package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.Label;

import java.util.List;

@Component
public class LabelDAO {
    private final SqlSession sqlSession;

    public LabelDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public List<Label> getLabelList(){
        List<Label> result=sqlSession.selectList("label.labelShow");
        return result;
    }
}
