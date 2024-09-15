package com.cloth.BF.Controller;

import com.cloth.BF.Entity.Product;
import com.cloth.BF.Exceptions.ResourceNotFoundException;
import com.cloth.BF.ServiceRepo.ProductService;
import com.cloth.BF.Utility.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloth")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<ProductDto> add(@RequestBody ProductDto productDto){
       ProductDto productDto1= this.productService.add(productDto);
       return new ResponseEntity<>(productDto1, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(this.productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id) throws ResourceNotFoundException {

        return new ResponseEntity<>(this.productService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        this.productService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateById(@PathVariable Integer id, @RequestBody ProductDto productDto) throws ResourceNotFoundException {

        return new ResponseEntity<>(this.productService.update(id, productDto), HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateQuant(@PathVariable int id, @RequestBody ProductDto i) throws ResourceNotFoundException {
        ProductDto productDto= this.productService.updateQuantity(id, i.getQuantity());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


}
