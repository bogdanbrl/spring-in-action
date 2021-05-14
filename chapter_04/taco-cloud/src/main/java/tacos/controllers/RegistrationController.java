package tacos.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.domain.RegistrationForm;
import tacos.domain.Role;
import tacos.domain.User;
import tacos.repository.UserRepository;
import tacos.services.RoleService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public RegistrationController(
            UserRepository userRepo, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {

        Role role = null;

        if(roleService.getByName("ROLE_USER") == null){
            roleService.add(new Role("ROLE_USER"));
        }

        role = roleService.getByName("ROLE_USER");

        User user = form.toUser(passwordEncoder);
        user.getRoles().add(role);
        userRepo.save(user);

        return "redirect:/login";
    }

}
