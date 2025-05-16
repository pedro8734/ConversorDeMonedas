import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double cantidadOriginal;
    private final double cantidadConvertida;
    private final LocalDateTime fechaHora;

    public RegistroConversion(String monedaOrigen, String monedaDestino, double cantidadOriginal, double cantidadConvertida, LocalDateTime fechaHora) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOriginal = cantidadOriginal;
        this.cantidadConvertida = cantidadConvertida;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaFormateada = fechaHora.format(formatter);
        return String.format("[%s] %.2f %s => %.2f %s",
                fechaFormateada, cantidadOriginal, monedaOrigen, cantidadConvertida, monedaDestino);
    }
}