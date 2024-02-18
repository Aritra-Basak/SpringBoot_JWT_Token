package com.java.springBoot_jwt_demo.entity;

import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class JwtResponse {
    String jwtToken;
    String username;
    Date expiryDate;
}
