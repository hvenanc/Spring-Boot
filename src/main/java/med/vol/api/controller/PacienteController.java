package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.entities.DadosPaciente;
import med.vol.api.entities.ListarPacientes;
import med.vol.api.entities.Paciente;
import med.vol.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<ListarPacientes> buscarPacientes(@PageableDefault(size = 10,sort = "nome")Pageable paginas) {
        return repository.findAll(paginas).map(ListarPacientes::new);
    }
}
