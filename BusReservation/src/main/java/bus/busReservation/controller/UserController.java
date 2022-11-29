package bus.busReservation.controller;

import bus.busReservation.domain.User;
import bus.busReservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //비밀번호 암호화

    @GetMapping("/bus")
    public String busForm(){
        return "user/busForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){return "user/loginForm";}

    @GetMapping("/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        if(user.getId().contains("user")){
            user.setRole("ROLE_USER");
        } else if (user.getId().contains("bus")) {
            user.setRole("ROLE_BUS");
        }
        String rawPassword=user.getPassword();
        String encPassword=bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userService.save(user);

        return "redirect:/loginForm"; //redirect를 붙이면 위의 loginForm 함수로 이동
    }
}
