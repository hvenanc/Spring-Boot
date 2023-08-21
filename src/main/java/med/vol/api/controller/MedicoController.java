package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.entities.dto.AtualizarMedico;
import med.vol.api.entities.dto.DadosMedico;
import med.vol.api.entities.dto.ListarMedicos;
import med.vol.api.entities.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void cadatrarMedico(@RequestBody @Valid DadosMedico dados) {
        repository.save(new Medico(dados));
    }

    /* LISTAGEM MAIS COMUM SEM PAGINAÇÃO
    @GetMapping
    public List<ListarMedicos> buscarMedicos() {
        return repository.findAll().stream().map(ListarMedicos::new).toList();
    }
    */

    @GetMapping
    public Page<ListarMedicos> buscarMedicos(@PageableDefault(sort = "nome") Pageable paginas) {
        return repository.findAllByAtivoTrue(paginas).map(ListarMedicos::new);
    }

    @Transactional
    @PutMapping
    public void atualizarDadosMedicos(@RequestBody @Valid AtualizarMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    /*
    //Exclusão Comum
    @Transactional
    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id) {
        repository.deleteById(id);
    }
    */

    //Exclusão Lógica
    @Transactional
    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.inativar();
    }

    //Reativando Medico
    @Transactional
    @PutMapping("{id}")
    public void ativarMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.ativar();
    }
}
