import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void agregarProducto(Product product) {
        products.add(product);
        System.out.println(product.getName() + " add to the cart ");
    }

    public void eliminarProducto(Product producto) {
        products.remove(producto);
        System.out.println(producto.getName() + " removed from cart");
    }

   
    public void showproducts() {
        if (products.isEmpty()) {
            System.out.println("the cart is empty");
        } else {
            products.forEach(System.out::println);
        }
    }
}
