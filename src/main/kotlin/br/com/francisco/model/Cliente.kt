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

    @NotEmpty
    @RegExp(prefix = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}\$\n")
    val cpf : String,

    @NotNull
    @NotBlank
    val nome : String,

    @NotNull
    val endereco : String,

    @NotBlank
    @RegExp(prefix = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}\$\n")
    val contato: String,

    @NotBlank
    @NotNull
    val placaVeiculo : String,

    @NotBlank
    @NotNull
    val modeloVeiculo: String,

    @NotBlank
    @NotNull
    val valorVeiculo : BigDecimal,

    @NotBlank
    @NotNull
    val anoVeiculo : Long
)