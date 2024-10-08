public class Product {
    public enum Smartphones {
        Iphone14, Iphone15, Iphone16, SAmsungA10, SamsungA30 , Huaweip30, HuaweiY9, RedmiNote10
    }
    public enum Accessories{
        Flash_drive, Sd_card, Portable_Battery, Bluetooth_Speaker, Phone_Holder, Headphones, Phone_Case
    }

    private String name;
    private int id;
    private Smartphones category1;
    private Accessories category2;
    
    public Product(String name, int id, Smartphones category1) {
        this.name = name;
        this.category1 = category1;
    }
    public Product(String name, int id, Accessories category2) {
        this.name = name;
        this.category2 = category2;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public Smartphones getSmartphones() {
        return category1;
    }
    public Accessories getAccessories() {
        return category2;
    }
    
    @Override
    public String toString() {
        return "Product: " + name + " | Smartphones: " + category1 + " | Accessories " + category2;
    }

}
