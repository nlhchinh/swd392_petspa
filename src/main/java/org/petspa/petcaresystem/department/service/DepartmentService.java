package org.petspa.petcaresystem.department.service;

import org.petspa.petcaresystem.department.model.request.CreateDepartmentRequest;
import org.petspa.petcaresystem.department.model.request.UpdateDepartmentRequest;
import org.petspa.petcaresystem.pet.model.response.ResponseObj;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    ResponseEntity<ResponseObj> ViewAllDepartment();
    ResponseEntity<ResponseObj> CreateDepartment(CreateDepartmentRequest departmentRequest);
    ResponseEntity<ResponseObj> UpdateDepartment(Long Department_id, UpdateDepartmentRequest departmentRequest);
    ResponseEntity<ResponseObj> DeleteDepartment(Long Department_id);
    ResponseEntity<ResponseObj> RestoreDepartment(Long Department_id);
}
