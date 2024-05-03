package br.com.francisco.model

import org.intellij.lang.annotations.RegExp
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity(name = "cliente")
data class Cliente (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,
    val cpf : String,
    val nome : String,
    val endereco : String,
    val contato: String,
    val placaVeiculo : String,
    val modeloVeiculo: String,
    val valorVeiculo : BigDecimal,
    val anoVeiculo : Long
)