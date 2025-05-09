package com.juarcoding.pcmspringboot3.core;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface IService<T> {

    /** CRUD */
    public ResponseEntity<Object> save(T t, HttpServletRequest request);
    public ResponseEntity<Object> update(Long id, T t, HttpServletRequest request);
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request);
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request);
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request);
    public ResponseEntity<Object> findByParam(Pageable pageable,String columnName,String value, HttpServletRequest request);
//    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, LocalDate from,LocalDate to, HttpServletRequest request);

}
