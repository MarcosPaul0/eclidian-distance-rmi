import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

// Classe no servidor que implementa os métodos remotos
public class Distance extends UnicastRemoteObject implements IDistance {
    public Distance() throws RemoteException {}

    public double calculateEuclideanDistance(double a1, double a2, double b1, double b2) throws RemoteException {
        System.out.println(
            String.format("Calculando a distância entre os pontos A(%s, %s) e B(%s, %s)", a1, a2, b1, b2)
        );

        double distance = Math.sqrt(Math.pow((a1 - b1), 2) + Math.pow((a2 - b2), 2));

        return distance;
    }
}