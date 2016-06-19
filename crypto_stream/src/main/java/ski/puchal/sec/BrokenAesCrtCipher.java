package ski.puchal.sec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class BrokenAesCrtCipher {
	
	private static final Key KEY = new SecretKeySpec(CryptUtil.hex2byte("3e5f5dae72480cef961ae396bece3776"), "AES");

    public String encrypt(String plaintext) {
    	if (plaintext == null) {
    		return "";
    	}
    	try {
			byte[] resultByteArray = encryptText(plaintext);
			String resultWhole = CryptUtil.bytes2hex(resultByteArray);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < resultWhole.length(); i++) {
				sb.append(resultWhole.charAt(i));
				if (i % 90 == 0 && i > 0) {
					sb.append(" ");
				}
			}
			return sb.toString();
			
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | ShortBufferException
				| IllegalBlockSizeException | BadPaddingException e) {
			throw new RuntimeException();
		}
    	
    }
    
    private static byte[] encryptText(String plaintext) throws NoSuchAlgorithmException,
    NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
    InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException
    {
    	byte[] iv = new byte[16];	// This is bad, especially when using streaming mode
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // cipher
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, KEY, ivSpec);

        // encryption
        byte[] message = plaintext.getBytes();
        byte[] ciphertext = new byte[cipher.getOutputSize(message.length)];
        int ctLength = cipher.update(message, 0, message.length, ciphertext, 0);
        cipher.doFinal(ciphertext, ctLength);

        return ciphertext;
    }

}
