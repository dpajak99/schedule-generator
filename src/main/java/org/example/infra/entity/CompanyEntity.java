package org.example.infra.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "website")
    private String website;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "timezone")
    private String timezone;
    
    @Column(name = "lang")
    private String lang;
    
    @Column(name = "avatar")
    private String avatar;
    
    @Column(name = "business_card")
    private String businessCard;
}
