package com.sistemasactivos.jdbcByAry.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    private String accalias;
    private String acctype;

    public Account(String accalias, String acctype) {
        this.accalias = accalias;
        this.acctype = acctype;
    }
}
