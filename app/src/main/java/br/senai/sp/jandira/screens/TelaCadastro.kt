package br.senai.sp.jandira.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.R
import br.senai.sp.jandira.model.Usuario
import br.senai.sp.jandira.repository.UsuarioRepository

@Composable
fun TelaCadastro(controleDeNavegacao: NavHostController) {

    val cr = UsuarioRepository(LocalContext.current)

    var userState = remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var opcaoState = remember {
        mutableStateOf(true)
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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
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
                    .offset(y = -20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    fontSize = 50.sp,
                    color = Color(0xFFCF06F0),
                    fontWeight = FontWeight.ExtraBold,
                )
                Text(
                    text = "Please sign in to continue.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                )

                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .width(100.dp)
                        .height(100.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCF06F0),
                            shape = RoundedCornerShape(100.dp)
                        )

                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.photo),
                        contentDescription = "Imagem de perfil",
                        contentScale = ContentScale.Crop
                    )

                }

                Image(
                    painterResource(
                        id = R.drawable.camera
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .offset(y = -20.dp, x = 35.dp)
                )

            }
            Column(
                modifier = Modifier
                    .width(350.dp)
                    .offset(y = -60.dp)
            ) {
                OutlinedTextField(
                    value = userState.value,
                    onValueChange = {
                        userState.value = it
                    },
                    label = {
                        Row {
                            Image(
                                painterResource(id = R.drawable.user),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(20.dp)
                            )
                            Text(
                                text = "  Username",
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
                OutlinedTextField(
                    value = phoneState.value,
                    onValueChange = {
                        phoneState.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    label = {
                        Row {
                            Image(
                                painterResource(id = R.drawable.celular),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(20.dp)
                            )
                            Text(
                                text = "  Phone",
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
                            top = 10.dp
                        )
                        .fillMaxWidth()
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
                            top = 10.dp
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
                            top = 10.dp
                        )
                        .fillMaxWidth()
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = opcaoState.value,
                        onCheckedChange = {
                            opcaoState.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFCF06F0),
                            uncheckedColor = Color(0xFFCF06F0)
                        )
                    )
                    Text(text = "Over 18?")
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                              if (userState.value == "" || senhaState.value == "" || emailState.value == "" ||
                                  phoneState.value == ""){
                                  mensagemErroState.value = "Preencha todos os campos!"
                              } else {
                                  val usuario = Usuario (
                                      nome = userState.value,
                                      email = emailState.value,
                                      telefone = phoneState.value,
                                      isMaior = opcaoState.value,
                                      senha =  senhaState.value
                                  )

                                  cr.salvar(usuario = usuario)
                                  controleDeNavegacao.navigate("home")

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
                    Text(
                        text = "CREATE ACCOUNT",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )

                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
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
                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Already have an account? ",
                            fontSize = 13.sp,
                            color = Color.Gray,
                        )
                        Text(
                            text = "Sign in",
                            fontSize = 13.sp,
                            color = Color(0xFFCF06F0),
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.clickable {
                                controleDeNavegacao.navigate("login")
                            }
                        )
                    }
                }


            }

        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
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