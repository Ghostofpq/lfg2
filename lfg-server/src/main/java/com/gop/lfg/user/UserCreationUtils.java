package com.gop.lfg.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class UserCreationUtils {
    private static String key = "my_aes_secretkey";

    private UserCreationUtils() {
    }

    public static String encodeLoginAndEmail(User user) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final Base64.Encoder encoder = Base64.getUrlEncoder();
            final Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"));

            final String jsonInString = mapper.writeValueAsString(user);
            byte[] encryptedByte = cipher.doFinal(jsonInString.getBytes());
            return encoder.encodeToString(encryptedByte);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User decodeLoginAndEmail(final String encrypted) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final Base64.Decoder decoder = Base64.getUrlDecoder();
            final Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"));

            byte[] encryptedByte = decoder.decode(encrypted);
            byte[] decryptedByte = cipher.doFinal(encryptedByte);

            return mapper.readValue(new String(decryptedByte),User.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
