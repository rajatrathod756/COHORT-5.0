package com.example.module2.controllers;

import com.example.module2.dto.DepartmentDTO;
import com.example.module2.entities.DepartmentEntity;
import com.example.module2.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final ModelMapper modelMapper;
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, ModelMapper modelMapper) {
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable Long departmentId){
        DepartmentDTO departmentDTO= departmentService.getDepartmentById(departmentId);
        return departmentDTO;
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        List<DepartmentDTO> departmentDTOListList = departmentService.getALlDepartments();
        return departmentDTOListList;
    }

    @PostMapping
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO dept){
        DepartmentDTO newlyAddedDepartment = departmentService.addDepartment(dept);
        return newlyAddedDepartment;
    }

    @PutMapping(path = "/{departmentId}")
    public DepartmentDTO updateDepartment(@PathVariable Long departmentId,@RequestBody DepartmentDTO dept){
        return  departmentService.updateDepartment(departmentId,dept);
    }

    @DeleteMapping(path = "/{departmentId}")
    public void deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }

}
