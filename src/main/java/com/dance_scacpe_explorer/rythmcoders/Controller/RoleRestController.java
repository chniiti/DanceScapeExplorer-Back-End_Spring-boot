package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.Role;
import com.dance_scacpe_explorer.rythmcoders.Services.RoleIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleRestController {
    @Autowired
    RoleIService roleIService;
    @PostMapping("/addRole")
    public void addRole(@RequestBody Role r){
        roleIService.addRole(r);
    }
    @GetMapping("/getRoleById/{roleId}")
    public Role getRoleById(@PathVariable  long roleId){
        return roleIService.findRoleById(roleId);
    }
    @PutMapping("/updateRole")
    public void updateRole(@RequestBody Role role){
        roleIService.updateRole(role);
    }
    @DeleteMapping("/deleteRole")
    public void deleteRole(long id){
        roleIService.deleteRole(id);
    }
}