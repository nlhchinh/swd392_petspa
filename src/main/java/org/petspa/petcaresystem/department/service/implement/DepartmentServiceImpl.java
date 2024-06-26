package org.petspa.petcaresystem.department.service.implement;

import org.petspa.petcaresystem.department.mapper.DepartmentMapper;
import org.petspa.petcaresystem.department.model.entity.Departments;
import org.petspa.petcaresystem.department.model.request.CreateDepartmentRequest;
import org.petspa.petcaresystem.department.model.request.UpdateDepartmentRequest;
import org.petspa.petcaresystem.department.model.response.DepartmentResponse;
import org.petspa.petcaresystem.department.repository.DepartmentRepository;
import org.petspa.petcaresystem.department.service.DepartmentService;
import org.petspa.petcaresystem.enums.Status;
import org.petspa.petcaresystem.medicine.mapper.MedicineMapper;
import org.petspa.petcaresystem.medicine.model.entity.Medicine;
import org.petspa.petcaresystem.medicine.model.response.MedicineResponse;
import org.petspa.petcaresystem.pet.model.entity.MedicalRecord;
import org.petspa.petcaresystem.pet.model.response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public ResponseEntity<ResponseObj> ViewAllDepartment() {
        try {
            List<Departments> departmentList = departmentRepository.findAll();

            ResponseObj responseObj = ResponseObj.builder()
                    .message("Load Department Successfully")
                    .data(departmentList)
                    .build();
            return ResponseEntity.ok().body(responseObj);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Fail to load")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObj);
        }
    }

    @Override
    public ResponseEntity<ResponseObj> CreateDepartment(CreateDepartmentRequest departmentRequest) {
        try {

            Departments department = new Departments();

            department.setDepartmentName(departmentRequest.getDepartmentName());

            department.setAddress(departmentRequest.getAddress());

            department.setStatus(Status.ACTIVE);

            Departments createDepartment = departmentRepository.save(department);

            DepartmentResponse departmentResponse = DepartmentMapper.toDepartmentResponse(createDepartment);

            ResponseObj responseObj = ResponseObj.builder()
                    .message("Create Department Successfully")
                    .data(departmentResponse)
                    .build();
            return ResponseEntity.ok().body(responseObj);

        } catch (Exception e) {
            e.printStackTrace();
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Fail to load")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObj);
        }
    }

    @Override
    public ResponseEntity<ResponseObj> UpdateDepartment(Long Department_id, UpdateDepartmentRequest departmentRequest) {
        try {
            Departments department = departmentRepository.getReferenceById(Department_id);
            List<Departments> departmentList = departmentRepository.findAll();
            for (Departments department1 : departmentList) {
                if (department1.equals(department) && department1.getStatus().equals(Status.ACTIVE)) {

                    department.setDepartmentName(departmentRequest.getDepartmentName());

                    department.setAddress(departmentRequest.getAddress());

                    department.setStatus(departmentRequest.getStatus());

                    Departments updateDepartment = departmentRepository.save(department);

                    DepartmentResponse departmentResponse = DepartmentMapper.toDepartmentResponse(updateDepartment);

                    ResponseObj responseObj = ResponseObj.builder()
                            .message("Update Department Successfully")
                            .data(departmentResponse)
                            .build();
                    return ResponseEntity.ok().body(responseObj);
                }
            }
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Department not found")
                    .data(null)
                    .build();
            return ResponseEntity.ok().body(responseObj);

        } catch (Exception e) {
            e.printStackTrace();
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Fail to load")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObj);
        }
    }

    @Override
    public ResponseEntity<ResponseObj> DeleteDepartment(Long Department_id) {
        try {
            Departments department = departmentRepository.getReferenceById(Department_id);
            List<Departments> departmentList = departmentRepository.findAll();
            for (Departments department1 : departmentList) {
                if (department1.equals(department) && department1.getStatus().equals(Status.ACTIVE)) {

                    department.setStatus(Status.INACTIVE);

                    departmentRepository.save(department);

                    ResponseObj responseObj = ResponseObj.builder()
                            .message("Delete Department Successfully")
                            .build();
                    return ResponseEntity.ok().body(responseObj);
                }
            }
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Department not found")
                    .data(null)
                    .build();
            return ResponseEntity.ok().body(responseObj);

        } catch (Exception e) {
            e.printStackTrace();
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Fail to load")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObj);
        }
    }

    @Override
    public ResponseEntity<ResponseObj> RestoreDepartment(Long Department_id) {
        try {
            Departments department = departmentRepository.getReferenceById(Department_id);
            List<Departments> departmentList = departmentRepository.findAll();
            for (Departments department1 : departmentList) {
                if (department1.equals(department) && department1.getStatus().equals(Status.ACTIVE)) {

                    department.setStatus(Status.ACTIVE);

                    Departments restoreDepartment = departmentRepository.save(department);

                    DepartmentResponse departmentResponse = DepartmentMapper.toDepartmentResponse(restoreDepartment);

                    ResponseObj responseObj = ResponseObj.builder()
                            .message("Restore Department Successfully")
                            .data(departmentResponse)
                            .build();
                    return ResponseEntity.ok().body(responseObj);
                }
            }
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Department not found")
                    .data(null)
                    .build();
            return ResponseEntity.ok().body(responseObj);

        } catch (Exception e) {
            e.printStackTrace();
            ResponseObj responseObj = ResponseObj.builder()
                    .message("Fail to load")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObj);
        }
    }
}
