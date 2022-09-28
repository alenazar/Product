import java.util.Arrays;

public class ProductManager {


    private ProductRepository repository;


    public ProductManager() {
        this.repository = new ProductRepository();
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.getProductRepository()) {
            if (matches(product, text)) {
                result = addElementUsingArraysCopyOf(result,product);
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    private Product[] addElementUsingArraysCopyOf(Product[] srcArray, Product elementToAdd) {
        Product[] destArray = Arrays.copyOf(srcArray, srcArray.length + 1);
        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }


}