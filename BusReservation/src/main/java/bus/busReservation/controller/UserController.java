package bus.busReservation.controller;

import bus.busReservation.domain.User;
import bus.busReservation.dto.ReservationDto;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.service.ReservationService;
import bus.busReservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ReservationService reservationService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //비밀번호 암호화

    @GetMapping("/bus")
    public String busForm(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        List<ReservationDto> reservationDtoList= reservationService.findByReservation(username);
        model.addAttribute("reservationList",reservationDtoList);

        return "user/busForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){return "user/loginForm";}

    @GetMapping("/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(User user,Model model){
        //System.out.println(user);
        if(user.getId().contains("user")){
            user.setRole("ROLE_USER");
        } else if (user.getId().contains("bus")) {
            user.setRole("ROLE_BUS");
        }
        String rawPassword=user.getPassword();
        String encPassword=bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userService.save(user);
        model.addAttribute("user",user);

        return "redirect:/loginForm"; //redirect를 붙이면 위의 loginForm 함수로 이동
    }
}
