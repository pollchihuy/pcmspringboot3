package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.config.OtherConfig;
import com.juarcoding.pcmspringboot3.dto.validation.ValUserDTO;
import com.juarcoding.pcmspringboot3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Qualifier("resourceHandlerMapping")


    @PostMapping
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> save(@Valid @RequestBody ValUserDTO valUserDTO,
                                       HttpServletRequest request){
        return userService.save(userService.mapToUser(valUserDTO),request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> update(@Valid @RequestBody ValUserDTO valUserDTO,
                                       @PathVariable Long id,
                                       HttpServletRequest request){
        return userService.update(id, userService.mapToUser(valUserDTO),request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> delete(@PathVariable Long id,
                                         HttpServletRequest request){
        return userService.delete(id,request);
    }

    /** defaultSearch
     * Ketika menu dibuka pertama kali, api yang di hit adalah api ini ....
     */
    @GetMapping
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> findAll(HttpServletRequest request){
        Pageable pageable = PageRequest.of(0, OtherConfig.getDefaultPaginationSize(), Sort.by("id"));
        return userService.findAll(pageable,request);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> findById(
            @PathVariable Long id,
            HttpServletRequest request){
        return userService.findById(id,request);
    }

    @GetMapping("/{sort}/{sort-by}/{page}")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> findByParam(
            @PathVariable String sort,
            @PathVariable(value = "sort-by") String sortBy,
            @PathVariable Integer page,
            @RequestParam Integer size,
            @RequestParam String column,
            @RequestParam String value,
            HttpServletRequest request){
        Pageable pageable = null;
        sortBy = sortColumn(sortBy);
        switch (sort) {
            case "desc":pageable = PageRequest.of(page,size, Sort.by("id").descending());break;
            default:pageable = PageRequest.of(page,size, Sort.by("id"));break;
        }
        return userService.findByParam(pageable,column,value,request);
    }

    @PostMapping("/upload-excel")
    @PreAuthorize("hasAuthority('User')")
    public ResponseEntity<Object> uploadExcel(@RequestParam MultipartFile file, HttpServletRequest request){
        return userService.uploadDataExcel(file,request);
    }

    @GetMapping("/download-excel")
    @PreAuthorize("hasAuthority('User')")
    public void downloadExcel(@RequestParam String column,
            @RequestParam String value,
            HttpServletRequest request,
            HttpServletResponse response){
        userService.downloadReportExcel(column,value,request,response);
    }

    @GetMapping("/download-pdf")
    @PreAuthorize("hasAuthority('User')")
    public void downloadPdf(@RequestParam String column,
                              @RequestParam String value,
                              HttpServletRequest request,
                              HttpServletResponse response){
        userService.generateToPDF(column,value,request,response);
    }

    private String sortColumn(String column){
        switch (column){
            case "nama-lengkap":column="nama-lengkap";break;
            case "username":column="username";break;
            case "alamat":column="alamat";break;
            case "tanggal-lahir":column="tanggal-lahir";break;
            case "no-hp":column="no-hp";break;
            case "email":column="email";break;
            default:column="id";break;
        }
        return column;
    }
}