import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteJuego {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.29.59.56", 5000);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

            String mensajeServidor;
            while ((mensajeServidor = entrada.readLine()) != null) {
                System.out.println("Servidor: " + mensajeServidor);

                // Si el juego ha terminado, no pedir más input
                if (mensajeServidor.startsWith("🎉 Juego terminado")) {
                    break;
                }

                // Solo si es una pregunta, pedir respuesta
                if (mensajeServidor.startsWith("Pregunta")) {
                    System.out.print("Tu respuesta: ");
                    String respuesta = consola.readLine();
                    salida.println(respuesta);
                }
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
