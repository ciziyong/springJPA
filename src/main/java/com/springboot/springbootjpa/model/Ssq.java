package com.springboot.springbootjpa.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="SSQ")
@NoArgsConstructor
public class Ssq {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer red1;
    private Integer red2;
    private Integer red3;
    private Integer red4;
    private Integer red5;
    private Integer red6;
    private Integer blue;
}
