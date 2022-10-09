import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
   public Server() {}

   public static void main(String args[]) {
      try { 
         int port = 3333;

          LocateRegistry.createRegistry(port);

          Naming.rebind(String.format("rmi://localhost:%s/Distance", port), new Distance());

          System.out.println(String.format("Servidor está rodando na porta %s", port));
      } catch (Exception error) { 
          System.out.println("ERRO no Servidor: " + error.toString()); 
          error.printStackTrace(); 
      }
   }
}

