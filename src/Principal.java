import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer entradas del usuario
        ServicioDeConversion servicio = new ServicioDeConversion(); // Servicio para manejar las conversiones
        boolean salir = false; // Controla la salida del programa

        while (!salir) { // Bucle principal del menú
            System.out.println("\n=== ******* CONVERSOR DE MONEDAS ****** ===");
            System.out.println("1) Pesos Colombianos -> Dólar USA");
            System.out.println("2) Dólar USA -> Pesos Colombianos");
            System.out.println("3) Pesos Argentinos -> Dólar USA");
            System.out.println("4) Dólar USA -> Pesos Argentinos");
            System.out.println("5) Reales Brasileños -> Dólar USA");
            System.out.println("6) Dólar USA -> Reales Brasileños");
            System.out.println("7) Bolívares de Venezuela -> Dólar USA");
            System.out.println("8) Dólar USA -> Bolívares de Venezuela");
            System.out.println("9) Ver historial de conversiones");
            System.out.println("10) Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 10) {
                salir = true;
                System.out.println("Gracias por usar el conversor.");
            } else if (opcion == 9) {
                servicio.mostrarHistorial(); // Muestra el historial de conversiones
            } else {
                System.out.print("Ingresa la cantidad: ");
                double cantidad = scanner.nextDouble();
                servicio.RelizarElCambio(opcion, cantidad); // Realiza la conversión solicitada
            }
        }
    }
}
