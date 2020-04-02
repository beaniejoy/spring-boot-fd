package kr.co.joy.eatgo.domain;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find User " + id);
    }
}
