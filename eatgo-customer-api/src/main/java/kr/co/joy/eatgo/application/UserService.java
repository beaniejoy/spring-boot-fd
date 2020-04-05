package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public User registerUser(String email, String name, String password) {

        //email 존재 여부 확인 -> Exception Throw
        Optional<User> existed = userRepository.findByEmail(email);
        if (existed.isPresent()) {
            throw new EmailExistedException(email);
        }

        // 패스워드 해시 인코딩 작업
        String encodedPassword = passwordEncoder.encode(password);

        // 기본 레벨을 설정해주어야 한다.
        User user = User.builder()
                .email(email)
                .name(name)
                .password(encodedPassword)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

}
