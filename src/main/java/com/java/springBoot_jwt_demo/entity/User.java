package com.java.springBoot_jwt_demo.entity;

//import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString
//@Entity
//@Table(name="JWT_User_Details")
public class User {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name="user_id")
    String userId;
    //@Column(name="user_name")
    String name;
    //@Column(name="email_id")
    String email;
    //@Column(name="user_password")
    String password;
    //@Column(name="user_role")
    String role;

}
