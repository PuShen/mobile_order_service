package wxp.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import wxp.service.entity.User;

import java.util.List;

@Component
public class UserDao {
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public List<User> getUserByUsername(String username){
        return sqlSession.selectList("user.selectUserByUsername",username);
    }
}
