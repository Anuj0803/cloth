package com.cloth.BF.ServiceRepo;

import com.cloth.BF.Entity.Product;
import com.cloth.BF.Exceptions.ResourceNotFoundException;
import com.cloth.BF.Utility.ProductDto;

import java.util.List;

public interface ProductService {

       ProductDto add(ProductDto productDto);
       ProductDto update(int id, ProductDto productDto) throws ResourceNotFoundException;

       void delete(int id) throws ResourceNotFoundException;

       List<ProductDto> getAll();

       ProductDto getById(int id) throws ResourceNotFoundException;

       ProductDto updateQuantity(int id, int i) throws ResourceNotFoundException;


}
