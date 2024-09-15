import java.util.Scanner;

public class Store_Manager {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to My virtual Shop");

        // Selecction Of Category 
        boolean continuarCompra = true;
        while (continuarCompra) {
            System.out.println("Seleccione una categoría para ver los productos:");
            for (Product.Smartphones category1 : Product.category1.values()) {
                System.out.println("-Smartphones" + category1);
            }
            System.out.println("Seleccione una categoría para ver los productos:");
            for (Product.Accessories  category2 : Product.category2.values()) {
                System.out.println("-Accessories" + category2);
            }

            String inputCategoria = scanner.nextLine().toUpperCase();
            Product.Smartphones categoriaSeleccionada;

            try {
                categoriaSeleccionada = Product.category1.valueOf(inputCategoria);
                tienda.mostrarProductosPorCategoria(categoriaSeleccionada);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoría no válida.");
                continue;
            }

            // Agregar productos al carrito
            boolean seguir = true;
            while (seguir) {
                System.out.print("Ingrese el ID del producto que desea agregar al carrito (0 para salir de la categoría): ");
                int idProducto = scanner.nextInt();
                if (idProducto == 0) {
                    seguir = false;
                } else {
                    Producto producto = tienda.obtenerProductoPorId(idProducto);
                    if (producto != null) {
                        carrito.agregarProducto(producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }
            }

            // Preguntar si desea seguir comprando en otra categoría
            System.out.print("¿Desea seguir comprando? (S/N): ");
            scanner.nextLine();  // Limpiar buffer
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("N")) {
                continuarCompra = false;
            }
        }

        // Crear cliente y realizar la orden
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese su dirección para el envío: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombreCliente, direccion);
        Orden orden = new Orden(cliente, carrito);

        // Despachar la orden
        orden.despachar();
    }
}