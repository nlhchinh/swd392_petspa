package org.petspa.petcaresystem.department.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.petspa.petcaresystem.doctor.model.Doctor;
import org.petspa.petcaresystem.enums.Status;

import java.util.Collection;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateDepartmentRequest {
    String departmentName;
    String address;
    Status status;
    Collection<Doctor> doctors;
}
