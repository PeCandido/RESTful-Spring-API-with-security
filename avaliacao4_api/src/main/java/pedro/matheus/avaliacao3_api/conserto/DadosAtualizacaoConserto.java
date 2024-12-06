package pedro.matheus.avaliacao3_api.conserto;

import jakarta.validation.constraints.NotNull;
import pedro.matheus.avaliacao3_api.mecanico.DadosMecanico;

public record DadosAtualizacaoConserto(
        @NotNull Long id,
        String saida,
        DadosMecanico mecanico) {
}
