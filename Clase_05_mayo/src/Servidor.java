import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        try {
            //Socket servidor
            ServerSocket socket_servidor = new ServerSocket(5000);
            System.out.println("Esperando la conexion...");
            while (true) {
                //Aceptar la conexion
                Socket socket_cliente = socket_servidor.accept();
                //Creacion de hilo para cliente
                HiloCliente hilo = new HiloCliente(socket_cliente);
                hilo.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
