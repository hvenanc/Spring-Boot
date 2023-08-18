package med.vol.api.entities;

public record ListarPacientes(String nome, String email, String cpf) {

    public ListarPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
