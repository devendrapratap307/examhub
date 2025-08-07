package com.examhub.examhub.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserBO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String mobile;

}
