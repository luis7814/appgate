package com.appgate.operation.data;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "operatorData")
public class OperatorData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idSession;
    private Integer idValue;
    private String operator;
    private Integer result;
    private Date date;

}
