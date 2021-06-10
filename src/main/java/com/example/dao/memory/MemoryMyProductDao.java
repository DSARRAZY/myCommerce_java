package com.example.dao.memory;

import com.example.dao.MyProductDao;
import com.example.dao.exception.UnknownProductException;
import com.example.model.MyProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryMyProductDao implements MyProductDao {

    private static List<MyProduct> products = new ArrayList();
    private static Long idSequence = 1L;


    private static int getProductIndexById(Long id) {
        for(int i = 0; i < products.size(); ++i) {
            MyProduct product = (MyProduct)products.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean create(MyProduct product) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        product.setId(var1);
        return products.add(product);
    }

    @Override
    public void update(MyProduct product) {
        int index = getProductIndexById(product.getId());
        if (index > -1) {
            products.set(index, product);
        } else {
            throw new UnknownProductException(product.getId());
        }
    }

    @Override
    public MyProduct findById(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            MyProduct product = (MyProduct)products.get(index);
            return product;
        } else {
            throw new UnknownProductException(id);
        }
    }

    @Override
    public List<MyProduct> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void remove(MyProduct product) {
        removeById(product.getId());
    }

    @Override
    public void removeById(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            products.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }
}
