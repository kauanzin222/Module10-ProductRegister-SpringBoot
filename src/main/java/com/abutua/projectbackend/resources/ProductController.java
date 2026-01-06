package com.abutua.projectbackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.ProductRepository;

@RestController
@CrossOrigin
public class ProductController {

        /* private List<Product> products = new ArrayList<>();
        
        @PostMapping("Products")
        public ResponseEntity<Product> save(@RequestBody Product product) {
                product.setId(products.size() + 1);
                products.add(product);

                URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(product.getId())
                                .toUri();

                return ResponseEntity.created(location).body(product);
        }

        
        @GetMapping("Products/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable int id) {

                // if (id <= products.size() && id > 0)
                // return ResponseEntity.ok(products.get(id - 1));
                // else {
                // throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product NOT FOUND");
                // }

                // Programação Funcional
                Product prod = products.stream() // Transforma a lista em um fluxo de dados
                                .filter(p -> p.getId() == id)
                                // filter passa por CADA PRODUTO e pergunta:
                                // o id do produto em questão é igual ao id do Path?
                                .findFirst() // Me devolva o PRIMEIRO produto a passar no filtro!
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                "Product NOT FOUND"));
                // Caso contrário, lance a exceção. O resto do código não será lido.

                return ResponseEntity.ok(prod);
        } */

        @Autowired
        public ProductRepository productRepository;
        
        @GetMapping("Products")
        public List<Product> getProducts() {
                return productRepository.findAll();
        }
}
