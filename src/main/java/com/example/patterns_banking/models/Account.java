package com.example.patterns_banking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.patterns_banking.factory.AccountFactoryProvider.AccountType;

@Data
@NoArgsConstructor
@Entity(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String accountNumber;
  @Enumerated(EnumType.STRING)
  private AccountType accountType;
  private Double balance;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  @JsonBackReference
  private Customer customer;

  public abstract Double calculateDepositFee(Double amount);

  public void deposit(Double amount) {
    double fee = calculateDepositFee(amount);
    this.balance += amount - fee;
  }
}
