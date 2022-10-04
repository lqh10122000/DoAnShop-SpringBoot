package com.huyle.shop.Domain;


import com.huyle.shop.Constant.Status;
import com.huyle.shop.Constant.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="t_user", uniqueConstraints = {@UniqueConstraint(columnNames={"username"})})
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity{
    public static final String PW_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*@#$%^&+=!]).{8,}$"; // password regex

    @Email
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column(name = "firstName")
    private String firstName;


    @Column (name="lastName")
    private String lastName;

    @Column(name="status")
    @Enumerated(value= EnumType.STRING)
    @Builder.Default
    private Status status = Status.INACTIVE;

    public String getFullName() { return String.format("%s %s", this.getFirstName(), this.getLastName());}
}
