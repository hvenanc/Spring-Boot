package med.vol.api.entities;

import jakarta.validation.constraints.NotNull;

public record AtualizarMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
