package br.senai.sp.jandira.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.R
import br.senai.sp.jandira.model.Viagem
import java.time.LocalDate

class ViagemRepository {

    @Composable
    fun listarTodasAsViagens(): List<Viagem>{

        val londres = Viagem(
            1,
            destino = "Londres",
            descricao = "London is the capital and largest city of the United Kingdom, with a population of just under 9 million.",
            dataChegada = LocalDate.of(2019, 2, 18),
            dataPartida = LocalDate.of(2019, 2, 21),
            imagem = painterResource(id = R.drawable.londres)
        )

        val porto = Viagem(
            2,
            destino = "Porto",
            descricao = "Porto is the second city in Portugal, the capital of the Oporto District.",
            dataChegada = LocalDate.of(2022, 3, 10),
            dataPartida = LocalDate.of(2022, 3, 15),
            imagem = painterResource(id = R.drawable.porto)
        )

        return listOf(
            londres,
            porto
        )

    }

}