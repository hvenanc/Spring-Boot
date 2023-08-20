package med.vol.api.entities;

public record ListarMedicos(Long id, String nome, String email, Especialidade especialidade, String crm) {

    public ListarMedicos(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getEspecialidade(), medico.getCrm());
    }
}
