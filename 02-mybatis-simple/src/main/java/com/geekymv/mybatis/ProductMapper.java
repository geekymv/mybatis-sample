package com.geekymv.mybatis;

public interface ProductMapper {

    int insertProduct(Product product);

    Product queryProduct(Long productId);
}
