package br.senai.sp.jandira.repository

import android.content.Context
import br.senai.sp.jandira.dao.UsuarioDb
import br.senai.sp.jandira.model.Usuario

class UsuarioRepository(context: Context) {

    private val db = UsuarioDb.getBancoDeDados(context).usuarioDao()

    fun salvar (usuario: Usuario):Long{
        return db.salvar(usuario)
    }

    fun validaLogin(email:String, senha:String): Boolean {
        return db.logar(email, senha)
    }

}