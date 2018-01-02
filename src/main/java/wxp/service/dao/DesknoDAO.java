package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesknoDAO {
    private final SqlSession sqlSession;

    public DesknoDAO(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public List<String> getDesknoList(){
        List<String> result=sqlSession.selectList("deskno.desknoShow");
        return result;
    }
}
