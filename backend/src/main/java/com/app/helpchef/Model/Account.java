package com.app.helpchef.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "createDate")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "usersId")
    private Users user;
}
