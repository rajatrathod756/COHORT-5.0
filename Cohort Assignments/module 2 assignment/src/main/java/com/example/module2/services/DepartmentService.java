package com.example.module2.services;

import com.example.module2.dto.DepartmentDTO;
import com.example.module2.entities.DepartmentEntity;
import com.example.module2.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getALlDepartments(){
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return  departmentEntityList
                .stream()
                .map((departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class)))
                .collect(Collectors.toUnmodifiableList());
    }

    public DepartmentDTO getDepartmentById(Long departmentId){
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        DepartmentDTO departmentDTO = modelMapper.map(departmentEntity,DepartmentDTO.class);
        return departmentDTO;
    }

    public DepartmentDTO addDepartment(DepartmentDTO dept){
        DepartmentEntity toSaveEntity = modelMapper.map(dept,DepartmentEntity.class);
        DepartmentEntity departmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO dept){
        DepartmentEntity toUpdateEntity = modelMapper.map(dept,DepartmentEntity.class);
        toUpdateEntity.setId(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.save(toUpdateEntity);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public void deleteDepartment(Long departmentId){
        boolean doesExist = departmentRepository.existsById(departmentId);
        if(!doesExist) return;
        departmentRepository.deleteById(departmentId);
    }
}
