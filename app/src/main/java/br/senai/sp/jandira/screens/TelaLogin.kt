package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.repository.UsuarioRepository

@Composable
fun TelaLogin(controleDeNavegacao: NavHostController) {

    val cr = UsuarioRepository(LocalContext.current)

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp)
                        .background(
                            color = Color(0xFFCF06F0),
                            shape = RoundedCornerShape(
                                bottomStart = 16.dp
                            )
                        )
                )
            }

            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 60.sp,
                    color = Color(0xFFCF06F0),
                    fontWeight = FontWeight.ExtraBold,
                )
                Text(
                    text = "Please sign in to continue.",
                    fontSize = 16.sp,
                    color = Color.Gray,
                )
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    label = {
                        Row {
                            Image(
                                painterResource(id = R.drawable.email),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(20.dp)
                            )
                            Text(
                                text = "  Email",
                                color = Color.Black
                            )
                        }

                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                    shape = RoundedCornerShape(
                        16.dp
                    ),
                    modifier = Modifier
                        .padding(
                            top = 80.dp
                        )
                        .fillMaxWidth()
                )

                OutlinedTextField(
                    value = senhaState.value,
                    onValueChange = {
                        senhaState.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    label = {
                        Row {
                            Image(
                                painterResource(id = R.drawable.cadeadoo),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(20.dp)
                            )
                            Text(
                                text = "  Password",
                                color = Color.Black
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                    shape = RoundedCornerShape(
                        16.dp
                    ),
                    modifier = Modifier
                        .padding(
                            top = 20.dp
                        )
                        .fillMaxWidth()
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -30.dp),
            ) {
                Text(
                    text = mensagemErroState.value,
                    color = Color.Red
                )
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .offset(y = -70.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = {
                        if (emailState.value == "" || senhaState.value == ""){
                            mensagemErroState.value = "Email ou senhas incorretos"
                        } else {
                            val usuario = cr.validaLogin(emailState.value, senhaState.value)

                            if(usuario){
                                controleDeNavegacao.navigate("home")
                            }
                        }
                    },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color(0xFFCF06F0)
                        ),
                    shape = RoundedCornerShape(
                        12.dp
                    )

                ) {
                    Row {
                        Text(
                            text = "SIGN IN   ",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Image(
                            painterResource(id = R.drawable.seta),
                            contentDescription = ""
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = "Don’t have an account? ",
                        fontSize = 13.sp,
                        color = Color.Gray,
                    )
                    Text(
                        text = "Sign up",
                        fontSize = 13.sp,
                        color = Color(0xFFCF06F0),
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .clickable {
                            controleDeNavegacao.navigate("cadastro")
                        }
                    )
                }


            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp)
                        .background(
                            color = Color(0xFFCF06F0),
                            shape = RoundedCornerShape(
                                topEnd = 16.dp
                            )
                        )
                )
            }
        }
    }
}