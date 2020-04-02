package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.User;
import kr.co.joy.eatgo.domain.UserNotFoundException;
import kr.co.joy.eatgo.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactivateUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.deactivate();

        return user;
    }
}
