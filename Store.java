import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<Product> availableproducts;

    public Store() {
        availableproducts = new ArrayList<>();
        initializeproducts();
    }

    private void initializeproducts() {
        availableproducts.add(new Product("Iphone14",  Product.Smartphones.Iphone14));
        availableproducts.add(new Product("Iphone15",  Product.Smartphones.Iphone15));
        availableproducts.add(new Product("Iphone16", Product.Smartphones.Iphone16));
        availableproducts.add(new Product("SAmsungA10",  Product.Smartphones.SAmsungA10));
        availableproducts.add(new Product("SamsungA30",  Product.Smartphones.SamsungA30));
        availableproducts.add(new Product("Huaweip30",  Product.Smartphones.Huaweip30));
        availableproducts.add(new Product("HuaweiY9", Product.Smartphones.HuaweiY9));
        availableproducts.add(new Product("RedmiNote10",  Product.Smartphones.RedmiNote10));
        availableproducts.add(new Product("Flash_drive",  Product.Accessories.Flash_drive));
        availableproducts.add(new Product("TV OLED",  Product.Accessories.TELEVISORES));
        availableproducts.add(new Product("Laptop",  Product.Accessories.COMPUTADORAS));
        availableproducts.add(new Product("Smartphone", Product.Accessories.SMARTPHONES));
        availableproducts.add(new Product("Audífonos", Product.Accessories.ACCESORIOS));
        availableproducts.add(new Product("Monitor", Product.Accessories.COMPUTADORAS));
        availableproducts.add(new Product("TV OLED",  Product.Accessories.TELEVISORES));
    }
    }
    }

    // Method to display products by category
    public void showproductsbycategory(Product.Smartphones category1) {
        System.out.println("Products on the category: " + category1);
        List<Product> productosFiltrados = availableproducts.stream()
                .filter(p -> p.getSmartphones() == category1)
                .collect(Collectors.toList());

        if (productosFiltrados.isEmpty()) {
            System.out.println("There are no products available in this category");
        } else {
            for (Product product : productosFiltrados) {
                System.out.println(product);
            }
        }
    }

    // Method to obtain a product by its name
    public Product ObtainProductByName(String name) {
        for (Product product : availableproducts) {
            if (product.getName() == name) {
                return product;
            }
        }
        return null; // If do not find the product
    }
}