package com.microservices.user.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String companyId;
    private String phoneNumber;
}
