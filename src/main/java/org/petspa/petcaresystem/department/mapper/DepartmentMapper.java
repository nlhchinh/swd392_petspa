package org.petspa.petcaresystem.department.mapper;

import org.petspa.petcaresystem.department.model.entity.Departments;
import org.petspa.petcaresystem.department.model.response.DepartmentResponse;

public class DepartmentMapper {
    public static DepartmentResponse toDepartmentResponse(Departments department){
        return DepartmentResponse.builder()
                .department_id(department.getDepartment_id())
                .departmentName(department.getDepartmentName())
                .address(department.getAddress())
                .doctors(department.getDoctor())
                .status(department.getStatus())
                .build();
    }
}
