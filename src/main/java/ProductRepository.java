public class ProductRepository {


    private Product[] productRepository = new Product[0];

    public void add(Product item) {
       Product[] tmp = new Product[productRepository.length + 1];
       for (int i = 0; i < productRepository.length; i++) {
           tmp[i] = productRepository[i];
        }
       tmp[tmp.length - 1] = item;
        productRepository = tmp;
    }

    public void delete(int id) {

        boolean isId = false;
        for (Product product : productRepository) {
            if (product.getId() == id) {
                isId = true;
                break;
            }
        }

        if (isId) {
            Product[] tmp = new Product[productRepository.length - 1];
            int copyToIndex = 0;
            for (Product product : productRepository) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            productRepository = tmp;
        }

    }


    public Product[] getProductRepository() {
        return productRepository;
    }
}
