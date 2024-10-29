package com.app.banking_app.pojo;

import jakarta.persistence.*;
import lombok.*;

@Table(name= "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "acc_holder_name")
    private String accHolderName;
    private double balance;
}
