package com.appgate.operation.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "sessionData")
public class SessionData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idSession;
    private Date date;
}
