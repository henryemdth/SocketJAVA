import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP{

	public static void main(String[] args) throws IOException{
		Socket	socketCliente = new Socket("localhost",4455);
		BufferedReader entrada =new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
		PrintWriter salida =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		
		System.out.println("===CLIENTE TCP===");
		BufferedReader sc= new BufferedReader(new InputStreamReader(System.in)); 
		String mensaje =sc.readLine();
		
		salida.println(mensaje);
		System.out.println("====>>>> RESPUESTA DE SERVIDOR");
		System.out.println(entrada.readLine());
		
		socketCliente.close();
		entrada.close();
		salida.close();
		sc.close();

	}

}
