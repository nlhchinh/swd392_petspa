package org.petspa.petcaresystem.pet.model.entity;

import jakarta.persistence.*;
import lombok.*;

import org.petspa.petcaresystem.appointment.model.Appointment;
import org.petspa.petcaresystem.authenuser.model.AuthenUser;
import org.petspa.petcaresystem.enums.Gender;
import org.petspa.petcaresystem.enums.Species;
import org.petspa.petcaresystem.enums.Status;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pet_id;

    @Column(name = "full_name")
    private String pet_name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "species")
    private Species species;

    @Column(name = "type_of_species")
    private String type_of_species;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AuthenUser owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Appointment> appointment;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<MedicalRecord> medicalRecord;

}
