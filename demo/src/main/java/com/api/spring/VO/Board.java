package com.api.spring.VO;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 3000, nullable = true)
    private String content;

    @CreatedDate
    private LocalDateTime date;

    @Column(nullable = true)
    private String picture;
}
