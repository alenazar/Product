import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Book testBook = new Book(100,"Муму",20,"Тургенев");
    Book testBook2 = new Book(110,"Война и Мир",25,"Толстой");
    Smartphone testSmartphone = new Smartphone(101,"Iphone 6",700,"Apple");

    @Test
    public void searchBy() {
        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testSmartphone);

        int expected = 1;
        int actual = productManager.searchBy("Му").length;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void deleteProduct(){

        ProductManager productManager = new ProductManager();
        productManager.add(testBook);
        productManager.add(testSmartphone);
        productManager.delete(100);

        int expected = 0;
        int actual = productManager.searchBy("Муму").length;

        Assertions.assertEquals(expected, actual);

    }
}
