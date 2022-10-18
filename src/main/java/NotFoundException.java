public class NotFoundException extends RuntimeException {

    public NotFoundException(String notFound) {
        super(notFound);
    }
}
