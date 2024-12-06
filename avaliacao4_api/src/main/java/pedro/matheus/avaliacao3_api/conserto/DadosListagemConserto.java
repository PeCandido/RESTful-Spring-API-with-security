package pedro.matheus.avaliacao3_api.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosListagemConserto(
        Long id,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String entrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,
        @NotBlank
        String nome_mecanico,
        @NotBlank
        String marca_veiculo,
        @NotBlank
        String modelo_veiculo) {

    public DadosListagemConserto(Conserto conserto){
        this(   conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
