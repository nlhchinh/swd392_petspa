package org.petspa.petcaresystem.authenuser.mapper;

import org.petspa.petcaresystem.authenuser.model.entity.AuthenUser;
import org.petspa.petcaresystem.authenuser.model.response.AuthenuserResponse;

public class AuthenUserMapper {
    public static AuthenuserResponse toAuthenUserResponse(AuthenUser authenUser){
        return AuthenuserResponse.builder()
                .full_name(authenUser.getFull_name())
                .gender(authenUser.getGender())
                .address(authenUser.getAddress())
                .phone(authenUser.getPhone())
                .email(authenUser.getEmail())
                .build();
    }
}