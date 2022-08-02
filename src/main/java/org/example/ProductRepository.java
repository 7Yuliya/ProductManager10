package org.example;

public class ProductRepository {


    private Product [] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {

            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
    public Product[] findAll() {
        Product [] tmp = new Product [products.length ];

        for (int i = 0; i < products.length; i++) {

            tmp [i] = products  [products.length - 1 - i];
        }
        return tmp;
    }

    //  return products;
    // }
    public Product findById(int id) {

        for (Product Product :
                     products  ) {
                if (id != Product.getId() ) {

                    throw new NotFoundException("Element with id: " + id + " not found");
                }

            return Product;

    }






    return null;

    }


    public Product removeById(int id) {
         //  Product[] tmp = new Product[products.length - 1];
       //int copyToIndex = 0;
      //for (Product Product :
      //      products  ) {
     //     if (Product.getId() !=  id) {
      //       tmp[copyToIndex] = Product;

        //     copyToIndex++;
       //   }

        //  products  = tmp;


    return findById( id);

    }
}

