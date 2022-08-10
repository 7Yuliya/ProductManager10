package org.example;

public class ProductRepository {


    Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {

            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        Product result = null;
        for (Product product :
                products) {
            if (product.getId() == id) {

                result = product;

                break;
            }
        }
        return result;


    }

    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException("Element with id: " + removeId + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product :
                products) {
            if (product.getId() != removeId) {
                tmp[copyToIndex] = product;

                copyToIndex++;
            }

            products = tmp;
        }
    }

    public Product[] findAll() {
        //  Product[] tmp = new Product[products.length];

        //  for (int i = 0; i < products.length; i++) {

        //     tmp[i] = products[products.length - 1 - i];
        //  }
        //  return tmp;
        //  }

        return products;
    }


}





