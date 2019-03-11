package com.capgemini.heskuelita.core.beans;

import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class User {

    private String userName;
    private String password;
    private String email;
    private LocalDate created;
    private LocalDate updated;

}
