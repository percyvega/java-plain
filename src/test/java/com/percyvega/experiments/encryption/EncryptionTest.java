package com.percyvega.experiments.encryption;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptionTest {

    @Test
    void encryptAndDecrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String message = "my message!";
        String encrypted = EncryptionUtil.encrypt(message);
        String decrypted = EncryptionUtil.decrypt(encrypted);

        assertThat(decrypted).isEqualTo(message);

    }

}
