package com.gop.lfg.user;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserCreationUtilsTest {

    @Test
    public void test_encrypt_decrypt_user() {
        final User user = User.builder()
                .login("josé")
                .email("josey.bovey@gmail.com+lfg")
                .build();

        final String encodedString = UserCreationUtils.encodeLoginAndEmail(user);

        final User decodedUser = UserCreationUtils.decodeLoginAndEmail(encodedString);

        assertNotNull(decodedUser);
        assertEquals(user.getLogin(), decodedUser.getLogin());
        assertEquals(user.getEmail(), decodedUser.getEmail());
    }
}