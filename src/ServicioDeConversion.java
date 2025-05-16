import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioDeConversion {
    private final String API_URL = "https://v6.exchangerate-api.com/v6/5e0632345b1c688a73731683/latest/USD";

    private final HttpClient client = HttpClient.newHttpClient(); // Cliente HTTP
    private final Gson gson = new Gson(); // Para convertir JSON a objetos Java
    private final List<RegistroConversion> historial = new ArrayList<>(); // Lista de registros de conversiones

    String monedaOrigen = "";
    String monedaDestino = "";

    // Método principal para realizar una conversión según opción y cantidad
    public void RelizarElCambio(int opcion, double cantidad) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Monedas moneda = gson.fromJson(response.body(), Monedas.class); // Convertimos JSON a objeto Monedas

            // Asignación de moneda origen y destino según la opción elegida
            switch (opcion) {
                case 1 -> { monedaOrigen = "COP"; monedaDestino = "USD"; }
                case 2 -> { monedaOrigen = "USD"; monedaDestino = "COP"; }
                case 3 -> { monedaOrigen = "ARS"; monedaDestino = "USD"; }
                case 4 -> { monedaOrigen = "USD"; monedaDestino = "ARS"; }
                case 5 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
                case 6 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
                case 7 -> { monedaOrigen = "VES"; monedaDestino = "USD"; }
                case 8 -> { monedaOrigen = "USD"; monedaDestino = "VES"; }
                default -> {
                    System.out.println("Opción no válida.");
                    return;
                }
            }

            // Se calcula la tasa de cambio y el resultado
            double tasa = calcularTasa(moneda, monedaOrigen, monedaDestino);
            double resultado = cantidad * tasa;

            // Se muestra el resultado de la conversión
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);

            // Se registra la conversión en el historial
            historial.add(new RegistroConversion(monedaOrigen, monedaDestino, cantidad, resultado, LocalDateTime.now()));

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método auxiliar para calcular la tasa entre dos monedas usando tasas relativas al USD
    private double calcularTasa(Monedas moneda, String origen, String destino) {
        double usdAOrigen = moneda.conversion_rates().get(origen);   // Tasa de USD a moneda origen
        double usdADestino = moneda.conversion_rates().get(destino); // Tasa de USD a moneda destino
        return usdADestino / usdAOrigen;
    }

    // Muestra todas las conversiones realizadas hasta el momento
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("🔔 No hay conversiones registradas aún.");
        } else {
            System.out.println("\n📜 HISTORIAL DE CONVERSIONES");
            System.out.println("══════════════════════════════════════════════════════════════════");

            for (int i = 0; i < historial.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, historial.get(i).toString());
            }

            System.out.println("══════════════════════════════════════════════════════════════════");
        }
    }
}
