package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyModel {
    private Long id;

    private String name;

    private String website;

    private String phone;

    private String email;

    private String timezone;

    private String lang;

    private String avatar;
}
