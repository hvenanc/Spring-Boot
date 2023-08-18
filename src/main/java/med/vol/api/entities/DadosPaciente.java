package med.vol.api.entities;

public record DadosPaciente(String nome, String email, String telefone,
                            String cpf, DadosEndereco endereco) {
}
