public class Order {
    private Customer customer;
    private Cart cart;

    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public void send() {
        System.out.println("The order has been sent to : " + customer.getAdress());
        System.out.println("Summary of the order:");
        cart.showproducts();
            }
}
