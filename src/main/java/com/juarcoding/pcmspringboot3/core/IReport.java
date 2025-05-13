package com.juarcoding.pcmspringboot3.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IReport<G> {

    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request);//100-110
    public List<G> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId);//111-120
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response);//121-130
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response);//131-140
}