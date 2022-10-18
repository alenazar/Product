import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Book testBook = new Book(100,"Муму",20,"Тургенев");
    Book testBook2 = new Book(110,"Война и Мур",25,"Толстой");
    Smartphone testSmartphone = new Smartphone(101,"Iphone 6",700,"Apple");

    @Test
    public void searchByOneFound() {
        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testBook2);
        productManager.add(testSmartphone);

        Product[] expected = new Product[1];
        expected[0] = testBook;
        Product[] actual = productManager.searchBy("му");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByTwoFound() {
        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testBook2);
        productManager.add(testSmartphone);

        Product[] expected = new Product[2];
        expected[0] = testBook;
        expected[1] = testBook2;
        Product[] actual = productManager.searchBy("Му");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByEmptyFound() {
        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testBook2);
        productManager.add(testSmartphone);

        Product[] expected = new Product[0];
        Product[] actual = productManager.searchBy("па");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void deleteProduct(){

        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testSmartphone);
        productManager.removeById(100);

        int expected = 0;
        int actual = productManager.searchBy("Муму").length;

        Assertions.assertEquals(expected, actual);

    }
}
