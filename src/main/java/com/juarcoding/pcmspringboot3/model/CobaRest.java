package com.juarcoding.pcmspringboot3.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
//@Table(name = "MstCobaRest")
//@Table(name = "MST_COBA_REST")
public class CobaRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Data1", nullable = false,length = 50)
    private String data1;

    @Column(name = "Presisih")
    private Double presisih;

    /** change when migration */
    @Column(name = "Data2")
    private String data2;

    @Column(name = "CreatedBy",updatable = false)
    private Long createdBy;//Yngwie
    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate;//kamis 21 April 2025

    @Column(name = "ModifiedBy",insertable = false)
    private Long modifiedBy;
    @Column(name = "ModifiedDate",insertable = false)
    private LocalDateTime modifiedDate;

    public Double getPresisih() {
        return presisih;
    }

    public void setPresisih(Double presisih) {
        this.presisih = presisih;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}