package kr.co.joy.eatgo.application;

public class PasswordWrongException extends RuntimeException{
    public PasswordWrongException() {
        super("Password is wrong!");
    }
}
