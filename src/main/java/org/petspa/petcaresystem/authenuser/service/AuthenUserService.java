package org.petspa.petcaresystem.authenuser.service;

import org.petspa.petcaresystem.authenuser.model.AuthenUser;
import org.petspa.petcaresystem.authenuser.model.ResponseAPI;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthenUserService {

    public ResponseAPI getUsers();
    public ResponseAPI register(AuthenUser authenUser);

    public UserDetails loadUserByEmail(String email) throws Exception;
}
