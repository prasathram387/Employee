package com.ideas2it.service;

import com.ideas2it.exception.CustomException;
import com.ideas2it.dao.RoleDao;
import com.ideas2it.model.Role;

public class RoleService {
    
    private RoleDao roleDao = new RoleDao();

    public Role getRoleByName(String roleName) throws CustomException {
        return roleDao.retrieveRoleByName(roleName);
    }
}