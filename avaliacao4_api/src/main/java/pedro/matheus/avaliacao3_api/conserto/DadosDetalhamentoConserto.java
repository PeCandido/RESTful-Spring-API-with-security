package pedro.matheus.avaliacao3_api.conserto;

import pedro.matheus.avaliacao3_api.mecanico.Mecanico;
import pedro.matheus.avaliacao3_api.veiculo.Veiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String entrada,
        String saida,
        Veiculo veiculo,
        Mecanico mecanico) {
    public DadosDetalhamentoConserto(Conserto conserto) {
        this(   conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getVeiculo(),
                conserto.getMecanico());
    }
}
