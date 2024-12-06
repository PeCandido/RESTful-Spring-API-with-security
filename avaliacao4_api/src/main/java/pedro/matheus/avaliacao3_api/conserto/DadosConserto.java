package pedro.matheus.avaliacao3_api.conserto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pedro.matheus.avaliacao3_api.mecanico.DadosMecanico;
import pedro.matheus.avaliacao3_api.mecanico.Mecanico;
import pedro.matheus.avaliacao3_api.veiculo.DadosVeiculo;
import pedro.matheus.avaliacao3_api.veiculo.Veiculo;

public record DadosConserto(
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String entrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,
        @NotNull
        @Valid
        DadosVeiculo veiculo,
        @NotNull
        @Valid
        DadosMecanico mecanico) {

}
