package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.Role;

public interface RoleIService {

    void addRole(Role r);
    Role findRoleById(long id);
    void updateRole(Role role);
    void deleteRole(long id);
}