package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.model.Role;
import ar.com.maxi.challengemonitoring.repository.IRoleRepository;
import ar.com.maxi.challengemonitoring.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
