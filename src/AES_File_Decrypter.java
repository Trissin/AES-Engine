import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.io.File;
import java.io.FileOutputStream;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AES_File_Decrypter
{
  public static void main(String[] argv) throws Exception
  {
      String uCiphertext = "";  // string to hold user input
      String uKey = "";
      File cipherText = new File ("AESEncrypted_Ciphertext.txt");
      File cipherKey = new File ("AESEncrypt_Key.txt");
      
      Scanner cipherScanner = new Scanner(cipherText);  // scanner
      Scanner keyScanner = new Scanner(cipherKey);
      
      while (cipherScanner.hasNext())
      {
          uCiphertext = cipherScanner.nextLine();
        }
        
        while (keyScanner.hasNext())
      {
          uKey = keyScanner.nextLine();
        }
      
      
      long aTime = System.nanoTime(); // get the current time
      /* ----------------------Begin decryption ---------------------------*/ 
      byte[] decodedKey = Base64.getDecoder().decode(uKey);
      SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
      Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      desCipher.init(Cipher.DECRYPT_MODE, originalKey);
      byte [] bytes = Base64.getDecoder().decode(uCiphertext); 
      byte[] decryptedMessage = desCipher.doFinal(bytes);
      /*-------------------------Finish Decryption--------------------------*/
      long bTime = System.nanoTime();  // get the time
      
      FileOutputStream fos = new FileOutputStream("AESdecrypted.txt");
      fos.write(decryptedMessage);
      fos.close();
      
      System.out.println("\nA new file has been created containing the decrypted contents.");
      System.out.println("\nTime before decryption: " + aTime + " nanoseconds.");
      System.out.println("Time after decryption: " + bTime + " nanoseconds.");
      float decryptTime = (bTime - aTime)/1000;
      System.out.println ("Time taken to decrypt: " + decryptTime + " microseconds.");

  }
}