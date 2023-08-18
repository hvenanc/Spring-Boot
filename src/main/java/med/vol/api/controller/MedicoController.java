package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.entities.DadosMedico;
import med.vol.api.entities.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadatrarMedico(@RequestBody @Valid DadosMedico dados) {
        repository.save(new Medico(dados));
        System.out.println(dados);
    }
}
