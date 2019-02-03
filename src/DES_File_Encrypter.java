import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
/**
 * Encrypts a file using DES encryption. Returns the ciphertext, the key, and the time.
 *
 * @author (James Pan)
 * @version (June 2017)
 */
public class DES_File_Encrypter
{
  public static void main(String[] argv) throws Exception
  {
      byte[] bArray = "initializer".getBytes();
      long aTime = System.nanoTime(); // get the current time
      /* ----------------------Begin encryption ---------------------------*/
      Path fileLocation = Paths.get("text.txt");
      byte[] data = Files.readAllBytes(fileLocation);
      
      KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
      SecretKey key = keygenerator.generateKey();
      String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
      Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      desCipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] encryptedMessage = desCipher.doFinal(data);
      /*-------------------------Finish Encryption--------------------------*/
      long bTime = System.nanoTime();  // get the time
      
      try
      {
          PrintWriter writer = new PrintWriter("DESEncrypted_File_Info.txt", "UTF-8");
          writer.println("Encrypted Ciphertext: " + Base64.getEncoder().encodeToString(encryp‌​tedMessage));
          writer.println("\n\nKey: " + encodedKey);
          writer.close();
        } 
        catch (IOException e) 
        {
            // do something
        }
        
        try
      {
          PrintWriter encryptOutput = new PrintWriter("DESEncrypted_Ciphertext.txt", "UTF-8");
          encryptOutput.println(Base64.getEncoder().encodeToString(encryp‌​tedMessage));
          encryptOutput.close();
        } 
        catch (IOException e) 
        {
            // do something
        }
        
        try
      {
          PrintWriter keyOutput = new PrintWriter("DESEncrypt_Key.txt", "UTF-8");
          keyOutput.println(encodedKey);
          keyOutput.close();
        } 
        catch (IOException e) 
        {
            // do something
        }
      /*---------Display details to the user-------------*/
      System.out.println("\nThe program has created a text file containing the ciphertext and the key.");
      System.out.println("\nTime before encryption: " + aTime + " nanoseconds.");
      System.out.println("Time after encryption: " + bTime + " nanoseconds.");
      float encryptTime = (bTime - aTime)/1000;
      System.out.println ("Time taken to encrypt: " + encryptTime + " microseconds.");

  }
}
  