package com.futuro_del_saber.controller;

import com.futuro_del_saber.model.StudentsModels;
import com.futuro_del_saber.servicio.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class StudentsController {

    @Autowired
    private StudentsService service;

    @PostMapping
    public ResponseEntity<StudentsModels> crearEstudiante(@RequestBody StudentsModels models){
        var students = service.crearStudents(models);
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentsModels> actualizarEstudents(
            @PathVariable Long id,
            @RequestBody StudentsModels models
    )
    {
        StudentsModels students = service.updateStudent(id, models);
        if(students != null){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentsModels> detallesStudents(@PathVariable Long id){
        Optional<StudentsModels> students = service.detallesEstudents(id);
        return students.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<StudentsModels>> listado(){
        List<StudentsModels> listado = service.listadoStudents();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarStudents(@PathVariable Long id){
        try{
            service.eliminarStudents(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Obtener estudiantes en el último grado (Grado 11)
    @GetMapping("/grado/11")
    public ResponseEntity<List<StudentsModels>> obtenerEstudiantesGrado11() {
        List<StudentsModels> estudiantes = service.obtenerEstudiantesPorGrado(11);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    // Obtener estudiantes con edad entre 15 y 17 años
    @GetMapping("/edad/15-17")
    public ResponseEntity<List<StudentsModels>> obtenerEstudiantesEdad15a17() {
        List<StudentsModels> estudiantes = service.obtenerEstudiantesPorEdad(15, 17);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }








}
