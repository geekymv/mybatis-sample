package com.geekymv.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSimpleTest {

    @Test
    public void testQueryProduct() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {

            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            Product product = productMapper.queryProduct(1L);

            System.out.println(product.getProductName());
        }
    }
}
