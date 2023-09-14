package com.cgi.crudapp.service;

import com.cgi.crudapp.dao.ProductDao;
import com.cgi.crudapp.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(int productID);

    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProductById(int productID);


}
