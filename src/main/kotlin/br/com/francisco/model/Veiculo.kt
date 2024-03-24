package br.com.francisco.model

import lombok.Data
import javax.persistence.*

@Entity
@Data
data class Veiculo (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,
    val modelo : String,
    val marca : String,
    val placa : String,
    @ManyToOne(fetch = FetchType.LAZY)
    val cliente: Cliente
)