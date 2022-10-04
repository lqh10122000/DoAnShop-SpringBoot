package com.huyle.shop.Domain;

import com.huyle.shop.Constant.TokenType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="t_token")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue (generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id;


    @ToString.Exclude
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;


    @Column(name="type")
    @Enumerated(value = EnumType.STRING)
    private TokenType type;


    @Column(name="value")
    private String value;

    @Column(name="expiry_date")
    private LocalDateTime expiryDate;

}
