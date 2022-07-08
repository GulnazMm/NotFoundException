package ru.netology.product;

public class ProductManager {
    private ProductRepository repository;
    private Product[] products = new Product[0];


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] searchBy(String query) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(query)) {
                Product[] x = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    x[i] = result[i];
                }
                x[x.length - 1] = product;
                result = x;
            }

        }
        return result;

    }

    public boolean matches(Product product, String search) {

        return product.getName().contains(search);

    }
}
