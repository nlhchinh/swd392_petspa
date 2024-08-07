package org.petspa.petcaresystem.department.repository;

import org.petspa.petcaresystem.department.model.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long> {
    public Departments findByDepartmentId(Long id);

    public Departments findByDepartmentName(String name);
}
