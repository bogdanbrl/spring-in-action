package tacos.services;

import org.springframework.stereotype.Service;
import tacos.domain.Role;
import tacos.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void add(Role role){
        roleRepository.save(role);
    }

    public Role getByName(String name){
        return roleRepository.findByName(name);
    }

}
