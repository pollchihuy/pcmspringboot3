package com.juarcoding.pcmspringboot3.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MstContoh1")
public class Contoh1 {

    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    public String nama;

    @Column(length = 50, nullable = false)
    public String email;


}
