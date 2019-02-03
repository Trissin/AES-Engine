import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Scanner;

/**
 * Write a description of class AES_String_Encrypter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AES_Original_Encrypter
{
    /**
     * 1. Generate a plain text for encryption
     * 2. Get a secret key (printed in hexadecimal form). In actual use this must
     * by encrypted and kept safe. The same key is required for decryption.
     * 3.
     */
    public static void main(String[] args) throws Exception
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string to encrypt using AES: ");
        String plainText = keyboard.nextLine();
        
        float aTime = System.nanoTime();
        SecretKey secKey = getSecretEncryptionKey();
        byte[] cipherText = encryptText(plainText, secKey);
        float bTime = System.nanoTime();
        String decryptedText = decryptText(cipherText, secKey);
        float cTime = System.nanoTime();
        
        System.out.println("\nEncrypted CipherText (Hex Form): " + bytesToHex(cipherText));
        System.out.println("Key (Hex Form): " + bytesToHex(secKey.getEncoded()));
        System.out.println("Descrypted PlainText: " + decryptedText);
        
        
        System.out.println("\nTime before encryption: " + aTime + " nanoseconds.");
        System.out.println("Time after encryption: " + bTime + " nanoseconds.");
        
        float encryptTime = (bTime - aTime)/1000000;
        float decryptTime = (cTime - bTime)/1000000;
        float totalTime = (cTime - aTime)/1000000;
        System.out.println ("Time taken to encrypt: " + encryptTime + " milliseconds.");
        System.out.println ("Time taken to decrypt: " + decryptTime + " milliseconds.");
        System.out.println ("Process Length: " + totalTime + " milliseconds.");
    }
     
    /**
     * Gets the AES encryption key. In your actual programs, this should be safely
     * stored.
     * @return
     * @throws Exception
     */
    public static SecretKey getSecretEncryptionKey() throws Exception
    {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }
  
    /**
     * Encrypts plainText in AES using the secret key
     * @param plainText
     * @param secKey
     * @return
     * @throws Exception
     */
    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception
    {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }
     
    /**
     * Decrypts encrypted byte array using the key used for encryption.
     * @param byteCipherText
     * @param secKey
     * @return
     * @throws Exception
     */
    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception
    {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
     
    /**
     * Convert a binary byte array into readable hex form
     * @param hash
     * @return
     */
    private static String bytesToHex(byte[] hash)
    {
        return DatatypeConverter.printHexBinary(hash);
    }
}
