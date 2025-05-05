import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloCliente  extends Thread {

    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        //Crear buffer para recibir datos del cliente
        try {
            //Recibir datos del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Enviar datos del cliente
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            //Mensaje de entrada
            Scanner teclado = new Scanner(System.in);

            while (true) {
                /*String mensaje = entrada.readLine();
                System.out.println("Mensaje recibido: "+mensaje);

                //Mensaje de salida
                System.out.println("Ingresa un mensaje: ");
                String mensaje_ingresado = teclado.nextLine();
                String mensaje2 = mensaje_ingresado;
                salida.println(mensaje2);*/

                String mensaje = entrada.readLine();
                if (mensaje == null || mensaje.equalsIgnoreCase("salir")) {
                    System.out.println("Cliente desconectado.");
                    break;
                }

                System.out.println("Mensaje recibido: " + mensaje);

                // Enviar mensaje al cliente
                System.out.print("Ingresa un mensaje: ");
                String mensaje_ingresado = teclado.nextLine();
                salida.println(mensaje_ingresado);

                if (mensaje_ingresado.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

            }

            /*String mensaje2 = "Hola desde el servidor";
            salida.println(mensaje2);*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
