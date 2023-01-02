package com.example.LearnSpringProject.Entity;

import com.fasterxml.jackson.databind.deser.Deserializers;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer accType;
    private String currency; //parabirimi
    private Double accAmount;

    @ManyToOne
    private Customer customer;
}
