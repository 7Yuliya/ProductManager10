package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Ася", 1_000, "Иван Сергеевич Тургенев");
    Product product2 = new Book(2, "Князь Серебряный", 1_200, "Алексей Константинович Толстой");
    Product product3 = new Smartphone(7, "Самсунг", 15_000, "Южнокорейская группа компаний");
    Product product4 = new Smartphone(4, "Apple", 35_000, "Аиериканская корпорация");


    @BeforeEach
    public void setup() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }


    @Test
    public void ShouldRemoveById() {
        repo.removeById(product4.getId());
        Product[] actual = manager.findAll();
        Product[] expected = {product3, product2, product1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);

        });


    }

    @Test
    public void ShouldAddProduct() {


        Product[] actual = manager.findAll();
        Product[] expected = {product4, product3, product2, product1
        };

        assertArrayEquals(expected, actual);
    }

    @Test

    public void ShouldSearchByProduct() {


        Product[] actual = manager.searchBy("Самсунг");
        Product[] expected = {product3};

        assertArrayEquals(expected, actual);
    }
}


