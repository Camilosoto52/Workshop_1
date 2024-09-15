public class Product {
    public enum Category_Smartphones {
        Iphone14, Iphone15, Iphone16, SAmsungA10, SamsungA30 , Huaweip30, HuaweiY9, RedmiNote10
    }
    public enum Category_Accessories{
        Flash_drive, Sd_card, Portable_Battery, Bluetooth_Speaker, Phone_Holder, Headphones, Phone_Case
    }

    private String name;
    private Category_Smartphones category1;
    private Category_Accessories category2;
    
    public Product(String name, Category_Smartphones category1, Category_Accessories category2 ) {
        this.name = name;
        this.category1 = category1;
        this.category2 = category2;
    }

    public String getNombre() {
        return name;
    }
    public Category_Smartphones getCategory_Smartphones() {
        return category1;
    }
    public Category_Accessories getCategory_Accessories() {
        return category2;
    }
    
    @Override
    public String toString() {
        return "Producto: " + name + " | Category_Smartphones: " + category1 + " | Category_Accessories " + category2;
    }

}
