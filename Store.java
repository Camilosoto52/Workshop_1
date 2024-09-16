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
        availableproducts.add(new Product("Iphone14",1,  Product.Smartphones.Iphone14));
        availableproducts.add(new Product("Iphone15",2,  Product.Smartphones.Iphone15));
        availableproducts.add(new Product("Iphone16",3, Product.Smartphones.Iphone16));
        availableproducts.add(new Product("SAmsungA10",4,  Product.Smartphones.SAmsungA10));
        availableproducts.add(new Product("SamsungA30",5,  Product.Smartphones.SamsungA30));
        availableproducts.add(new Product("Huaweip30",6,  Product.Smartphones.Huaweip30));
        availableproducts.add(new Product("HuaweiY9",7, Product.Smartphones.HuaweiY9));
        availableproducts.add(new Product("RedmiNote10",8,  Product.Smartphones.RedmiNote10));
        availableproducts.add(new Product("Flash_drive",9,  Product.Accessories.Flash_drive));
        availableproducts.add(new Product("Sd_card",10,  Product.Accessories.Sd_card));
        availableproducts.add(new Product("Portable_Battery",11,  Product.Accessories.Portable_Battery));
        availableproducts.add(new Product("Bluetooth_Speaker",12, Product.Accessories.Bluetooth_Speaker));
        availableproducts.add(new Product("Phone_Holder",13, Product.Accessories.Phone_Holder));
        availableproducts.add(new Product("Headphones",14, Product.Accessories.Headphones));
        availableproducts.add(new Product("Phone_Case",15,  Product.Accessories.Phone_Case));
    }
    
    

    // Method to display products by category
    public void showproductsbySmartphones(Product.Smartphones category1) {
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
    public void showproductsbyAccesories(Product.Accessories category2) {
        System.out.println("Products on the category: " + category2);
        List<Product> productosFiltrados = availableproducts.stream()
                .filter(p -> p.getAccessories() == category2)
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
    public Product ObtainProductById(int id) {
        for (Product product : availableproducts) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // If do not find the product
    }
}