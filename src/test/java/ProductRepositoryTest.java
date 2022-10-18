import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Book testBook = new Book(100,"Муму",20,"Тургенев");
    Book testBook2 = new Book(110,"Война и Мир",25,"Толстой");
    Smartphone testSmartphone = new Smartphone(101,"Iphone 6",700,"Apple");


    @Test
    public void addProduct(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.add(testBook);
        productRepository.add(testSmartphone);

        int expected = 2;
        int actual = productRepository.getProductRepository().length;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void deleteProductWithCorrectId(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.add(testBook);
        productRepository.add(testBook2);
        productRepository.add(testSmartphone);
        productRepository.removeById(100);

        int expected = 2;
        int actual = productRepository.getProductRepository().length;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void deleteProductWithInCorrectId(){
        ProductRepository productRepository = new ProductRepository();
        productRepository.add(testBook);
        productRepository.add(testBook2);
        productRepository.add(testSmartphone);

        Assertions.assertThrows(NotFoundException.class, () -> {
            productRepository.removeById(2);
        });

    }
}
