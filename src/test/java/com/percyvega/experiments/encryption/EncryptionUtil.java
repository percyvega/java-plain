package com.percyvega.experiments.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class EncryptionUtil {

    private static final String ALGORITHM = "AES";

    private static final SecretKey secretKey;
    private static final Cipher cipher;

    static {
        try {
            // Generate key
            secretKey = KeyGenerator.getInstance(ALGORITHM).generateKey();
            // Create Cipher instance
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String message) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Initialize cipher to ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the message
        byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        // Encode by converting the encrypted message to a Base64 encoded string
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String message) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Reinitialize the cipher to DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // We need to encode (and decode) using Base64 because the cipher.doFinal used for decoding requires a block size multiple of 16, or else:
        //      javax.crypto.IllegalBlockSizeException: Input length must be multiple of 16 when decrypting with padded cipher
        byte[] decoded = Base64.getDecoder().decode(message);
        // Decrypt the message
        byte[] decrypted = cipher.doFinal(decoded);

        return new String(decrypted, StandardCharsets.UTF_8);
    }

}
