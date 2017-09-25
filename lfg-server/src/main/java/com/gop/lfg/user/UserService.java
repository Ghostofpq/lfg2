package com.gop.lfg.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class UserService {
    private UserRepository userRepository;
    private ShaPasswordEncoder shaPasswordEncoder;
    @Value("${database.user.version}")
    private int version;

    @Autowired
    public UserService(final UserRepository userRepository, final ShaPasswordEncoder shaPasswordEncoder) {
        this.userRepository = userRepository;
    }

    public UserDTO create(final User user) throws UserAlreadyExistsException {
        try {
            final String salt = new String(KeyGenerators.secureRandom(32).generateKey());
            return userRepository.save(
                    UserDTO.builder()
                            .version(version)

                            .login(user.getLogin())
                            .email(user.getEmail())
                            .password(shaPasswordEncoder.encodePassword(user.getPassword(), salt))
                            .salt(salt)
                            .build());
        } catch (RuntimeException e) {
            throw new UserAlreadyExistsException();
        }
    }

    public UserDTO findById(final String id) {
        return userRepository.findOne(id);
    }

    public UserDTO update(final String id, final User user) throws UserNotFoundException {
        final UserDTO UserDTO = userRepository.findOne(id);
        if (UserDTO == null) {
            throw new UserNotFoundException();
        }

        return userRepository.save(UserDTO);
    }

    public void deleteById(final String id) {
        userRepository.delete(id);
    }
}
