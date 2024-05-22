package br.senai.sp.jandira.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario ): Long

    @Query("SELECT * FROM tbl_usuarios WHERE email = :email AND senha = :senha")
    fun logar(email: String, senha: String): Boolean
}