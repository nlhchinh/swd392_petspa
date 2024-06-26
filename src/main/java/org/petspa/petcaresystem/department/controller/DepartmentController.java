package org.petspa.petcaresystem.department.controller;

import org.petspa.petcaresystem.department.model.request.CreateDepartmentRequest;
import org.petspa.petcaresystem.department.model.request.UpdateDepartmentRequest;
import org.petspa.petcaresystem.department.service.DepartmentService;
import org.petspa.petcaresystem.pet.model.response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = {"/department/viewAllDepartment"})
    public ResponseEntity<ResponseObj> ViewAllDepartment(){
        return departmentService.ViewAllDepartment();
    }

    @PostMapping("/department/create")
    public ResponseEntity<ResponseObj> CreateDepartment(@RequestBody CreateDepartmentRequest departmentRequest){
        return departmentService.CreateDepartment(departmentRequest);
    }

    @PutMapping("/department/update")
    ResponseEntity<ResponseObj> UpdateDepartment(@RequestParam Long Department_id,
                                                 @RequestBody UpdateDepartmentRequest departmentRequest){
        return departmentService.UpdateDepartment(Department_id, departmentRequest);
    }

    @PutMapping("/department/detele")
    ResponseEntity<ResponseObj> DeleteDepartment(@RequestParam Long Department_id){
        return departmentService.DeleteDepartment(Department_id);
    }

    @PutMapping("/department/restore")
    ResponseEntity<ResponseObj> RestoreDepartment(@RequestParam Long Department_id){
        return departmentService.RestoreDepartment(Department_id);
    }
}
