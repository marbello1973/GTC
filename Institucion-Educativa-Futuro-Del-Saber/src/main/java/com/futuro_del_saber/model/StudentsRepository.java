package com.futuro_del_saber.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository extends JpaRepository<StudentsModels, Long> {
    // Obtener estudiantes del grado 11
    @Query("SELECT s FROM StudentsModels s WHERE s.grado_actual = :grado")
    List<StudentsModels> obtenerEstudiantesPorGrado(@Param("grado") int grado);

    // Obtener estudiantes con edad entre 15 y 17
    @Query("SELECT s FROM StudentsModels s WHERE s.edad BETWEEN :edadMin AND :edadMax")
    List<StudentsModels> obtenerEstudiantesPorEdad(@Param("edadMin") Byte edadMin, @Param("edadMax") Byte edadMax);
}
