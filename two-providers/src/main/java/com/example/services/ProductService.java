package com.example.services;

import com.example.DTOs.ProductDTO;
import com.example.models.Category;
import com.example.models.Product;
import com.example.models.User;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService extends AbstractService<Product> {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    public ProductService(ProductRepository mainRepository) {
        super(mainRepository);
    }

    public Product update(ProductDTO productDTO) {
        throw new UnsupportedOperationException("Method not implemented for the current type");
        //return this.update(new Product());
    }

    public ProductDTO createDTO(ProductDTO productDTO) {
        Product product = new Product(productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), productDTO.getImgs(),
                productDTO.getQuantity());
        product.setUser(userService.get(productDTO.getUserId()));
        product.setCategory(categoryService.get(productDTO.getCategoryId()));
        product.setId(this.create(product).getId());
        return productDTO;
    }
    //public ProductDTO(Long id, String name, String description, Long userId, Long categoryId, String imgs, int quantity, float price) {
    public ProductDTO getDTO(Long id){
       return this.get(this.get(id));
    }

    public ArrayList<ProductDTO> getDTOList(){
       return (ArrayList) this.findAll().stream().map(product -> this.get(product)).collect(Collectors.toList());
    }

    private ProductDTO get(Product product){
        return new ProductDTO(product.getId(), product.getName(),product.getDescription(),
                product.getUser().getId(),product.getCategory().getId(),
                product.getImgs(),product.getQuantity(), product.getPrice());
    }
}
