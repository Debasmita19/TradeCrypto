package tradeCrypto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    

    public ResponseEntity <User> register(User user) {
        
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setTwoFactorAuth(new TwoFactorAuth());

        User savedUser= userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);

        
    }
}
