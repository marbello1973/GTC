package com.futuro_del_saber.servicio;

import com.futuro_del_saber.model.StudentsModels;
import com.futuro_del_saber.model.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository repository;

    public StudentsModels crearStudents(StudentsModels models){

        StudentsModels st = new StudentsModels();
        st.setNombre(models.getNombre());
        st.setApellido(models.getApellido());
        st.setFecha_nacimiento(models.getFecha_nacimiento());
        st.setEdad(models.getEdad());
        st.setGrado_actual(models.getGrado_actual());
        st.setEmail(models.getEmail());
        st.setTelefono_fijo(models.getTelefono_fijo());
        st.setTelefono_celular(models.getTelefono_celular());
        st.setEstado(models.getEstado());

        var nuevoStudents = repository.save(st);
        return nuevoStudents;
    }

    public List<StudentsModels> listadoStudents(){
        var lista = repository.findAll();
        return List.copyOf(lista);
    }

    public void eliminarStudents (Long id){
        repository.deleteById(id);
    }

    public Optional<StudentsModels> detallesEstudents(Long id){
        return repository.findById(id);
    }

    public StudentsModels updateStudent(Long id, StudentsModels updatedStudent) {
        Optional<StudentsModels> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentsModels existingStudent = optionalStudent.get();
            existingStudent.setNombre(updatedStudent.getNombre());
            existingStudent.setApellido(updatedStudent.getApellido());
            existingStudent.setFecha_nacimiento(updatedStudent.getFecha_nacimiento());
            existingStudent.setEdad(updatedStudent.getEdad());
            existingStudent.setGrado_actual(updatedStudent.getGrado_actual());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setTelefono_fijo(updatedStudent.getTelefono_fijo());
            existingStudent.setTelefono_celular(updatedStudent.getTelefono_celular());
            existingStudent.setEstado(updatedStudent.getEstado());
            return repository.save(existingStudent);
        } else {

            return null;
        }
    }

    // Método para obtener estudiantes del grado 11
    public List<StudentsModels> obtenerEstudiantesPorGrado(int grado) {
        return repository.obtenerEstudiantesPorGrado(grado);
    }

    // Método para obtener estudiantes con edad entre 15 y 17
    public List<StudentsModels> obtenerEstudiantesPorEdad(int edadMin, int edadMax) {
        return repository.obtenerEstudiantesPorEdad((byte) edadMin, (byte) edadMax);
    }





}
