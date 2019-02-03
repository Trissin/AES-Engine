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
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AES_String_Decrypter
{
  public static void main(String[] argv) throws Exception
  {
      Scanner keyboard = new Scanner(System.in);  // scanner
      String uCiphertext;  // string to hold user input
      String uKey;
      System.out.println("Enter the ciphertext to decrypt using AES: "); // prompt
      uCiphertext = keyboard.nextLine(); // accept input
      System.out.println("Enter the AES key: "); // prompt
      uKey = keyboard.nextLine(); // accept input
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
      
      
      
      System.out.println("\nDecrypted Plaintext: " + new String(decryptedMessage));
      System.out.println("\nTime before decryption: " + aTime + " nanoseconds.");
      System.out.println("Time after decryption: " + bTime + " nanoseconds.");
      float decryptTime = (bTime - aTime)/1000;
      System.out.println ("Time taken to decrypt: " + decryptTime + " microseconds.");

  }
}