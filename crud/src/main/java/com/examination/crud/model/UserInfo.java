package com.examination.crud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {


    private static final long serialVersionUID = -3810752981219964805L;

    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer role;

    private Integer auth;

    private String token;

    private Byte status;
}
