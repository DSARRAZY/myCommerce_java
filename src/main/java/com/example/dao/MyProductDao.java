package com.example.dao;

import com.example.model.MyProduct;
import java.util.List;

public interface MyProductDao {

        boolean create(MyProduct product);

        void update(MyProduct product);

        MyProduct findById(Long id);

        List<MyProduct> findAll();

        void remove(MyProduct product);

        void removeById(Long id);

}

