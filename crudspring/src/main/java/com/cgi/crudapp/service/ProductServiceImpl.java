package com.cgi.crudapp.service;

import com.cgi.crudapp.dao.ProductDao;
import com.cgi.crudapp.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(int productID) {
        Product product = productDao.findById(productID).orElse(null);
        return product;
    }



    @Override
    public List<Product> getAllProducts() {
        List <Product> products = productDao.findAll();
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        Product newProduct = productDao.save(product);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product updatedProduct = productDao.save(product);
        return updatedProduct;
    }

    @Override
    public Product deleteProductById(int productID) {
        if (!productDao.existsById(productID)) {
            return null;
        }
        Product product = productDao.findById(productID).orElse(null);
        productDao.deleteById(productID);
        return product;
    }


}
