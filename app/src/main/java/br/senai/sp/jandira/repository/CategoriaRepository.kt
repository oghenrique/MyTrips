package br.senai.sp.jandira.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.R
import br.senai.sp.jandira.model.Categoria

class CategoriaRepository {

    @Composable
    fun listarTodasAsCategorias(): List<Categoria>{

        val montain = Categoria(
            1,
            categoria = "Montain",
            imagem = painterResource(id = R.drawable.montanha)
        )

        val snow = Categoria(
            1,
            categoria = "Snow",
            imagem = painterResource(id = R.drawable.snow)
        )

        val beach = Categoria(
            1,
            categoria = "Beach",
            imagem = painterResource(id = R.drawable.beach)
        )

        return listOf(
            montain,
            snow,
            beach
        )

    }

}