package pedro.matheus.avaliacao3_api.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank
        String nome,
        int experiencia) {
}
