package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component

public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

   public DataSeeder (ProductRepository productRepository,CategoryRepository categoryRepository){
       this.productRepository = productRepository;
       this.categoryRepository = categoryRepository;
   }
    @Override
    @Transactional
    public void run(String... args) throws Exception {

       //clear all existing data
        productRepository.deleteAllInBatch();
       categoryRepository.deleteAllInBatch();

        //create category
        Category electronics =new Category();
        electronics.setName("Electronics");

        Category clothing =new Category();
        clothing.setName("Clothing");

        Category home =new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        //Create products
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartphone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(9999.9);
        phone.setCategory(electronics);


        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop for gaming");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(99999.9);
        laptop.setCategory(electronics);


        Product jacket= new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy jacket for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(999.9);
        jacket.setCategory(clothing);

        Product blender= new Product();
        blender.setName("Blender");
        blender.setDescription("High speed blender");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(299.9);
        blender.setCategory(home);


        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));







    }
}






















