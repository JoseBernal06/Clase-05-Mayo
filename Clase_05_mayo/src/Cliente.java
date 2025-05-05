import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
      try {

          Socket socket_servidor = new Socket("172.29.59.56", 5000);
          //Recibir datos del cliente
          BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_servidor.getInputStream()));
          //Enviar datos del cliente
          PrintWriter salida = new PrintWriter(socket_servidor.getOutputStream(), true);

          while (true){
              //Mensaje de salida
              Scanner teclado = new Scanner(System.in);
              System.out.println("Ingresa un mensaje: ");
              String mensaje_ingresado = teclado.nextLine();
              String mensaje2 = mensaje_ingresado;
              salida.println(mensaje2);
              //Mensaje de entrada
              String mensaje = entrada.readLine();
              System.out.println("\nMensaje recibido: "+mensaje);

          }

      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }
}
