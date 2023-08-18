package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.entities.DadosPaciente;
import med.vol.api.entities.Paciente;
import med.vol.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    public void cadastrarPaciente(@RequestBody @Valid DadosPaciente dados) {
        repository.save(new Paciente(dados));
        System.out.println(dados);
    }
}
