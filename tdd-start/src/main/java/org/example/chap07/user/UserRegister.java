package org.example.chap07.user;

import org.example.chap07.user.exception.DupIdException;
import org.example.chap07.user.exception.WeakPasswordException;
import org.example.chap07.user.repository.UserRepository;
import org.example.chap07.user.util.EmailNotifier;
import org.example.chap07.user.util.WeakPasswordChecker;

public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        userRepository.save(new User("id", "pw", "email"));

        // 이메일 발송 기능 호출
        emailNotifier.sendRegisterEmail(email);
    }
}
