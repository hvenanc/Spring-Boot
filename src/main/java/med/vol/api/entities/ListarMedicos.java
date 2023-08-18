package med.vol.api.entities;

public record ListarMedicos(String nome, String email, Especialidade especialidade, String crm) {

    public ListarMedicos(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getEspecialidade(), medico.getCrm());
    }
}
