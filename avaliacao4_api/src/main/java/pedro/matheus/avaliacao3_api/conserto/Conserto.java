package pedro.matheus.avaliacao3_api.conserto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pedro.matheus.avaliacao3_api.mecanico.Mecanico;
import pedro.matheus.avaliacao3_api.veiculo.Veiculo;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entrada;
    private String saida;
    private Veiculo veiculo;
    private Mecanico mecanico;
    private boolean ativo;

    public Conserto(DadosConserto dados){
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.veiculo = new Veiculo(dados.veiculo());
        this.mecanico = new Mecanico(dados.mecanico());
        this.ativo = true;
    }

    public void atualizarinformacoes(DadosAtualizacaoConserto dados) {
        if(dados.saida() != null) this.saida = dados.saida();
        if(dados.mecanico() != null) this.mecanico.atualizarInformacoes(dados.mecanico());
    }

    public void excluir() {
        this.ativo = false;
    }
}
