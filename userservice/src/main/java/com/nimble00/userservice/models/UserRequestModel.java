package com.nimble00.userservice.models;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {
//    @JsonIgnore
    private String id;
    private String fullName;
    private String email;
    private String password;
}