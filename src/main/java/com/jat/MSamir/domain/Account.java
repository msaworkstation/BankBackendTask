package com.jat.MSamir.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jat.MSamir.domain.enums.AccountType;
import com.jat.MSamir.domain.enums.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long accountNumber;
    private Double balance;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @NotNull
    @Pattern(regexp = "[A-Z]{2}[0-9]{2}[A-Z0-9]{12,30}", message = "{account.iban.pattern}")
    private String iban;
    @JsonIgnore
    @OneToMany(mappedBy="account", fetch=FetchType.EAGER)
    private Set<Statement> statementList = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public boolean addStatement(Statement statement){
       return statementList.add(statement);
    }
}
