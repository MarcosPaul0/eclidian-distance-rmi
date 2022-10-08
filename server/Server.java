import java.rmi.Naming;

public class Server {
   public Server() {}

   public static void main(String args[]) {
      try { 
         int port = 3333;

          java.rmi.registry.LocateRegistry.createRegistry(port);

          Naming.rebind(String.format("rmi://localhost:%s/Distance", port), new Distance());

          System.out.println(String.format("Servidor está rodando na porta %s", port));
      } catch (Exception error) { 
          System.out.println("ERRO no Servidor: " + error.toString()); 
          error.printStackTrace(); 
      }
   }
}
