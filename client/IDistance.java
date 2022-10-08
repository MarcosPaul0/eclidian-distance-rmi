import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Criação de uma interface chamada IDistance, que define os contratos para acesso as funções de cada operação
// O I no início do nome da classe é um padrão de nomenclatura para interfaces
public interface IDistance extends Remote {  
   public double calculateEuclideanDistance(double a1, double a2, double b1, double b2) throws RemoteException;
} 