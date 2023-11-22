package com.userService.userService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "microuser")
public class User {
    @Id
    @Column(name="ID")
    private  String userId;
    @Column(name="USERNAME")
    private  String name;
    @Column(name="USEREMAIL")
    private  String email;
    @Column(name="ABOUTUSER" )
    private  String about;

    @Transient
    private  List<Rating> ratings;

}
