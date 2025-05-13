package com.juarcoding.pcmspringboot3.controller;


import com.juarcoding.pcmspringboot3.dto.validation.ValGroupMenuDTO;
import com.juarcoding.pcmspringboot3.service.GroupMenuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("group-menu")
public class GroupMenuController {


    @Autowired
    private GroupMenuService groupMenuService;


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ValGroupMenuDTO valGroupMenuDTO,
                                       HttpServletRequest request){
        return groupMenuService.save(groupMenuService.mapToGroupMenu(valGroupMenuDTO),request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody ValGroupMenuDTO valGroupMenuDTO,
                                       @PathVariable Long id,
                                       HttpServletRequest request){
        return groupMenuService.update(id,groupMenuService.mapToGroupMenu(valGroupMenuDTO),request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id,
                                         HttpServletRequest request){
        return groupMenuService.delete(id,request);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(HttpServletRequest request){
        Pageable pageable = PageRequest.of(0,3, Sort.by("id"));

        return groupMenuService.findAll(pageable,request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable Long id,
            HttpServletRequest request){
        return groupMenuService.findById(id,request);
    }
}
