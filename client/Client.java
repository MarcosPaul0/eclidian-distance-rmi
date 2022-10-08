import java.rmi.*;
import java.util.Scanner;

public class Client {
   private Client() {}

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);

      //Recebe os dados pelo usuário
      System.out.println("Entre com valores do ponto A separados por espaço:");
      double a1 = keyboard.nextDouble();
      double a2 = keyboard.nextDouble();
      System.out.println("");

      System.out.println("Entre com valores do ponto B separados por espaço:");
      double b1 = keyboard.nextDouble();
      double b2 = keyboard.nextDouble();
      System.out.println("");

      keyboard.close();

      try {
         int port = 3333;

         // Procura o registro do objeto remoto implementado no servidor
         IDistance stub = (IDistance) Naming.lookup(String.format("rmi://localhost:%s/Distance", port));
         
         System.out.println("Enviando dados...");

         // Chamada ao Método Remoto usando o objeto criado
         // Chamando a função e obtendo a resposta
         double distance = stub.calculateEuclideanDistance(a1, a2, b1, b2);

         // Imprime a resposta do cálculo da distancia Euclidiana do servidor no terminal
         System.out.println(
            String.format("A distância Euclidiana entre A(%s, %s) e B(%s, %s) é %s", a1, a2, b1, b2, distance)
         );
      } catch (Exception error) {
         System.err.println("ERRO no Cliente (Exception): " + error.toString());
         error.printStackTrace();
      }
   }
}
