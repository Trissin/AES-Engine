import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.Scanner;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DES_Original_Decrypter
{
  public static void main(String[] argv) throws Exception
  {
      Scanner keyboard = new Scanner(System.in);
      String uInput;
      
      System.out.println("Enter a string to encrypt using DES: ");
      uInput = keyboard.nextLine();
      /*--------------------------------------------------*/
      float aTime = System.nanoTime();    
      SecretKey key = KeyGenerator.getInstance("DES").generateKey();
      DesEncrypter encrypter = new DesEncrypter(key);
      String encrypted = encrypter.encrypt(uInput);
      float bTime = System.nanoTime();
      String decrypted = encrypter.decrypt(encrypted);
      

      System.out.println ("\nEncrypted Ciphertext: " + encrypted);
      System.out.println ("Decrypted Plaintext: " + decrypted);
      System.out.println ("Key: " + key);
      float cTime = System.nanoTime();
      /*--------------------------------------------------*/
      System.out.println("\nTime before encryption: " + aTime + " nanoseconds.");
      System.out.println("Time after encryption: " + bTime + " nanoseconds.");
      
      float encryptTime = (bTime - aTime)/1000000;
      float decryptTime = (cTime - bTime)/1000000;
      float totalTime = (cTime - aTime)/1000000;
      System.out.println ("Time taken to encrypt: " + encryptTime + " milliseconds.");
      System.out.println ("Time taken to decrypt: " + decryptTime + " milliseconds.");
      System.out.println ("Process Length: " + totalTime + " milliseconds.");
    }
}