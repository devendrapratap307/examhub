package com.examhub.examhub.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String mobile;

}
