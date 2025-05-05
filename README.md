# # 💱 Conversor de Monedas

Aplicación de consola desarrollada en **Java** que permite convertir entre monedas latinoamericanas y el dólar estadounidense utilizando una **API de tasas de cambio** en tiempo real. Incluye un historial de conversiones y una interfaz de usuario por consola.

---

## 🧰 Tecnologías y herramientas utilizadas

- 💻 **Lenguaje:** Java 17  
- 🔧 **IDE:** IntelliJ IDEA  
- 🌐 **API REST:** ExchangeRate API (para obtener tasas de cambio)  
- 🧪 **Librerías externas:**
  - `java.net.http.HttpClient` (peticiones HTTP)
  - `Gson` (parseo de JSON)
- 💾 **Control de versiones:** Git  
- ☁️ **Repositorio remoto:** GitHub  

---
## 🎯 Funcionalidades

- Conversión de:
  - Pesos Colombianos ↔ Dólar Estadounidense
  - Pesos Argentinos ↔ Dólar Estadounidense
  - Reales Brasileños ↔ Dólar Estadounidense
  - Bolívares Venezolanos ↔ Dólar Estadounidense
  - Acceso a tasas de cambio actualizadas
  - Registro en memoria de todas las conversiones realizadas
  - Menú interactivo por consola

---
## 🗂️ Estructura del proyecto
ConversorDeMonedas/
│
├── src/
│ ├── Principal.java # Clase principal con el menú de opciones
│ ├── ServicioDeConversion.java # Lógica de conexión con API y cálculo
│ ├── RegistroConversion.java # Historial de conversiones
│ └── Monedas.java # Clase para mapear respuesta JSON

👨‍💻 Autor
Pedro
GitHub: pedro8734

