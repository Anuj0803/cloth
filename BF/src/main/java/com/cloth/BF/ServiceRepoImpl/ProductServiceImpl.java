package com.cloth.BF.ServiceRepoImpl;

import com.cloth.BF.Entity.Product;
import com.cloth.BF.Exceptions.ResourceNotFoundException;
import com.cloth.BF.Repository.ProductRepo;
import com.cloth.BF.ServiceRepo.ProductService;
import com.cloth.BF.Utility.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;


    @Override
    public ProductDto add(ProductDto productDto) {
        Product product=covert(productDto);
       Product product1= this.productRepo.save(product);
       ProductDto productDto1=covertToDto(product1);
       return productDto1;
    }

    @Override
    public ProductDto update(int id, ProductDto productDto) throws ResourceNotFoundException {
        Product product1=this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found by id"+ id));
        product1.setName(productDto.getName());
        product1.setPrice(productDto.getPrice());
        product1.setBrand(productDto.getBrand());
        product1.setDescription(productDto.getDescription());
        product1.setColour(productDto.getColour());
       this.productRepo.save(product1);
       return covertToDto(product1);

    }

    @Override
    public void delete(int id) throws ResourceNotFoundException {
       Product product= this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no product with this id"+ id));
        this.productRepo.delete(product);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products=this.productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        for(Product p: products){
            ProductDto productDto=covertToDto(p);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductDto getById(int id) throws ResourceNotFoundException {
       Product product= this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("no product with this id"+ id));
       return covertToDto(product);
    }

    @Override
    public ProductDto updateQuantity(int id, int i) throws ResourceNotFoundException {
        Product product=this.productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("no product with this id"+ id));
        product.setQuantity(i);
        this.productRepo.save(product);
        return covertToDto(product);
    }

    ProductDto covertToDto(Product product){
        ModelMapper modelMapper = new ModelMapper();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    Product covert(ProductDto productDto){
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

}
