package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.entities.DadosMedico;
import med.vol.api.entities.ListarMedicos;
import med.vol.api.entities.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /* LISTAGEM MAIS COMUM SEM PAGINAÇÃO
    @GetMapping
    public List<ListarMedicos> buscarMedicos() {
        return repository.findAll().stream().map(ListarMedicos::new).toList();
    }
    */

    @GetMapping
    public Page<ListarMedicos> buscarMedicos(@PageableDefault(sort = "nome") Pageable paginas) {
        return repository.findAll(paginas).map(ListarMedicos::new);
    }
}
