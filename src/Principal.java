import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer entradas del usuario
        ServicioDeConversion servicio = new ServicioDeConversion(); // Servicio para manejar las conversiones
        boolean salir = false; // Controla la salida del programa

        while (!salir) { // Bucle principal del menú
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║       🌎 CONVERSOR DE MONEDAS       ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. 💵 COP → USD                      ║");
            System.out.println("║ 2. 💵 USD → COP                      ║");
            System.out.println("║ 3. 💵 ARS → USD                      ║");
            System.out.println("║ 4. 💵 USD → ARS                      ║");
            System.out.println("║ 5. 💵 BRL → USD                      ║");
            System.out.println("║ 6. 💵 USD → BRL                      ║");
            System.out.println("║ 7. 💵 VES → USD                      ║");
            System.out.println("║ 8. 💵 USD → VES                      ║");
            System.out.println("║ 9. 📜 Ver historial                  ║");
            System.out.println("║ 0. ❌ Salir                          ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
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
