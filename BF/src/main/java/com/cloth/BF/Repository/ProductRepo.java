package com.cloth.BF.Repository;

import com.cloth.BF.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
