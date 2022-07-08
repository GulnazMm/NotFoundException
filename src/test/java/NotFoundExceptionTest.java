import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.ProductRepository;
import ru.netology.product.Smartphone;
import ru.netology.product.NotFoundException;

public class NotFoundExceptionTest {
    Book book1 = new Book(15, "Книжка", 100, "И.И. Клюшкин");
    Book book2 = new Book(16, "Учебник", 150, "И.И. Плюшкин");
    Smartphone smartphone1 = new Smartphone(17, "Samsung", 200, "Samsung Group");
    Smartphone smartphone2 = new Smartphone(18, "Samsung10", 300, "Samsung Group");
    ProductRepository repository = new ProductRepository();

    @Test
    public void deleteProduct() {
        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.deleteByQuery(18);


        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, smartphone1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void NotFoundException() {
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone1);
        assertThrows(NotFoundException.class, () -> {
            repository.deleteByQuery(20);

        });
    }

}

