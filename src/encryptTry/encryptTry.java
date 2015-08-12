package encryptTry;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class encryptTry {
public static void main(String[] args)
{
	encryptTry ent = new encryptTry() ;
System.out.println(ent.encrypt(new String("Hello world"))) ;
System.out.println(ent.decrypt(ent.encrypt(new String("Hello world"))));
}
private static final String ALGO = "AES" ;
private static final byte[] keyValue = 
new byte[]{'T','h','e','b','e','s','t','s','e','c','r','e','t','k','e','y'} ;
public static String encrypt(String Data)
{
	 String encryptedValue =""	;
	try
	{
	Key key = generateKey() ;
Cipher c = Cipher.getInstance(ALGO) ;
c.init(Cipher.ENCRYPT_MODE,key) ;
byte[] encVal = c.doFinal(Data.getBytes());
encryptedValue= new Base64().encodeAsString(encVal) ;

	}catch(Exception e){e.printStackTrace() ;} 
	return encryptedValue ;
}
public static String decrypt(String encryptedData)
{
	String decryptedvalue = "" ;
	try
	{
Key key = generateKey() ;
Cipher c = Cipher.getInstance(ALGO) ;
c.init(Cipher.DECRYPT_MODE, key);
byte[] decValue= new Base64().decodeBase64(encryptedData) ;
byte[] decryptedValue = c.doFinal(decValue) ;
decryptedvalue = new String(decryptedValue) ;
	} catch (Exception e){e.printStackTrace();}
return decryptedvalue ;
	
}
public static Key generateKey()
{
	Key key = new SecretKeySpec(keyValue, ALGO) ;
	return key ;
}
	
}
