package com.example.LearnSpringProject.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String custName;
    private String custSurname;
    private String custMail;
    private String custPassword;
    private double custKazanc;

    @OneToMany
    private List<Account> accountList;

    @ManyToOne
    private Banks bank;

}
