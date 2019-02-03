import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.Scanner;
/**
 * Encrypts a String using DES encryption. Returns the ciphertext and the key.
 *
 * @author (James Pan)
 * @version (June 2017)
 */
public class DES_String_Encrypter
{
  public static void main(String[] argv) throws Exception
  {
      Scanner keyboard = new Scanner(System.in);  // scanner
      String uInput;  // string to hold user input
      System.out.println("Enter a string to encrypt using DES: "); // prompt
      uInput = keyboard.nextLine(); // accept input
      
      long aTime = System.nanoTime(); // get the current time
      /* ----------------------Begin encryption ---------------------------*/
      byte[] message = uInput.getBytes("UTF-8"); 
      KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
      SecretKey key = keygenerator.generateKey();
      String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
      Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      desCipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] encryptedMessage = desCipher.doFinal(message);
      /*-------------------------Finish Encryption--------------------------*/
      long bTime = System.nanoTime();  // get the time
      
      /*---------Display details to the user-------------*/
      System.out.println("\nEncrypted Ciphertext: " + Base64.getEncoder().encodeToString(encryp‌​tedMessage));
      System.out.println ("Key: " + encodedKey);
      System.out.println("\nTime before encryption: " + aTime + " nanoseconds.");
      System.out.println("Time after encryption: " + bTime + " nanoseconds.");
      float encryptTime = (bTime - aTime)/1000;
      System.out.println ("Time taken to encrypt: " + encryptTime + " microseconds.");

  }
}
  