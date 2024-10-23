package com.futuro_del_saber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estudiantes")
public class StudentsModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private Byte edad;
    private Byte grado_actual;
    private String email;
    private Integer telefono_fijo;
    private Integer telefono_celular;
    private Boolean estado;
}
