package br.com.francisco.model

import lombok.Data
import javax.persistence.*

@Entity
@Data
data class Cliente (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,
    val nome : String,
    val cpf : String,
    @OneToMany(mappedBy = "cliente", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val veiculos: List<Veiculo>
)