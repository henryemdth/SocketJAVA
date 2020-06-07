import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServidorTCP {

	public static void main(String[] args) throws IOException{
		ServerSocket socketServidor = null;
		Socket socketCliente =null;
		BufferedReader entrada=null;
		PrintWriter salida=null;
		try {
			socketServidor = new ServerSocket(4455);
			System.out.println("=====SERVIDOR TCP=====");
			while(true) {
				
				socketCliente = socketServidor.accept();
				entrada= new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				salida=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
				System.out.println("Conexin establecida:");
				Date fecha =new Date();
				salida.println("Mensaje: "+(entrada.readLine()).toUpperCase()+" \t\tFecha del sistema "+fecha);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		socketServidor.close();
		socketCliente.close();
		entrada.close();
		salida.close();
		
		
		
	}

}
