package ru.netology.product;


public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] x = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            x[i] = products[i];
        }
        x[x.length - 1] = product;
        products = x;
    }

    public Product[] findAll() {
        return products;
    }


    public Product[] deleteByQuery(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] x = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id)
                x[index] = product;
            index++;
        }
        products = x;

        return products;
    }

    public Product[] findById(int id) {
        Product[] ans = new Product[0];

        for (Product product : findAll()) {
            if (product.getId() == id) {
                Product[] y = new Product[ans.length + 1];
                System.arraycopy(findAll(), 0, y, 0, ans.length);
                int index = 0;
                y[index] = product;
                ans = y;
                return ans;
            }
        }
        return null;

    }

}


