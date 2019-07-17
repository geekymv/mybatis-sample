package com.geekymv.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSimple {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {

            Product product = new Product();
            product.setProductId(3L);
            product.setProductName("Java Core");

//            int result = sqlSession.insert("insertProduct", product);

            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            int result = productMapper.insertProduct(product);

            System.out.println("result = " + result);

            sqlSession.commit();
        }
    }

}
