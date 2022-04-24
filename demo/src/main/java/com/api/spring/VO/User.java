package com.api.spring.VO;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;


    @ColumnDefault("user")
    @Column(nullable = false)
    private String role;

    @Column(nullable = true)
    private String picture;

}
