package com.dance_scacpe_explorer.rythmcoders.Services;


import com.dance_scacpe_explorer.rythmcoders.Entities.Role;
import com.dance_scacpe_explorer.rythmcoders.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleService implements RoleIService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void addRole(Role role){
        roleRepository.save(role);
    }
    @Override
    public Role findRoleById(long roleId) {
        return roleRepository.findById(roleId).get();
    }

    @Override
    public void updateRole(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }
}
