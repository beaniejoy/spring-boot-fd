package kr.co.joy.eatgo.domain;

public class UserEmailExistedException extends RuntimeException {

    public UserEmailExistedException(String email) {
        super("Email is already registered: " + email);
    }
}
