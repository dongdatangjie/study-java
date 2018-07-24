package com.tangjie.mybatis.first;

        import com.tangjie.mybatis.entity.User;
        import org.apache.ibatis.io.Resources;
        import org.apache.ibatis.session.SqlSession;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.ibatis.session.SqlSessionFactoryBuilder;
        import org.junit.Test;

        import java.io.IOException;
        import java.io.InputStream;


public class MybatisFirst {

    @Test
    public void findUserById() throws IOException {

        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById",1);

        System.out.println(user);

        sqlSession.close();
    }
}
