package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    Product product1 = new Book(1, "Ася", 1_000, "Иван Сергеевич Тургенев");
    Product product2 = new Book(2, "Князь Серебряный", 1_200, "Алексей Константинович Толстой");
    Product product3 = new Smartphone(7, "Самсунг", 15_000, "Южнокорейская группа компаний");
    Product product4 = new Smartphone(4, "Apple", 35_000, "Аиериканская корпорация");

    @Test
    public void testRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(product4.getId());
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void testNotFoundException() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);

        });


    }

}

