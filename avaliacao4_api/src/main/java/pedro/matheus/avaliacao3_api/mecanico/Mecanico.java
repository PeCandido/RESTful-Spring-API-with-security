package pedro.matheus.avaliacao3_api.mecanico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int experiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados) {
        if(dados.nome() != null) this.nome = dados.nome();
        if(dados.experiencia() >= 0) this.experiencia = dados.experiencia();
    }
}
