package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "token")
@Getter
@Setter
@NoArgsConstructor
public class TokenEntity extends BaseEntity {
    @Column(name = "hashed_token")
    private String hashedToken;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expire_date")
    private Date expireDate;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TokenEntity(String hashedToken, Date expireDate, UserEntity user) {
        this.hashedToken = hashedToken;
        this.expireDate = expireDate;
        this.user = user;
    }

}
