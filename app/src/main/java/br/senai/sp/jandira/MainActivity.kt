package br.senai.sp.jandira

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.ui.theme.MyTripsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
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
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .offset(y = -70.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = { },
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
                        fontWeight = FontWeight.ExtraBold
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


@Composable
fun Tela2() {

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
                    onClick = { /*TODO*/ },
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
                            fontWeight = FontWeight.ExtraBold
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

@Composable
fun Tela3() {

    var searchState = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffF6F6F6)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.paris),
                    contentDescription = "Paris",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(60.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "Foto de Perfil",
                            contentScale = ContentScale.Crop,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                    ) {
                        Text(
                            text = "Gustavo Henrique",
                            color = Color.White
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 20.dp, bottom = 10.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Localização",
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "You're in Paris",
                            color = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 6.dp)
                    ) {
                        Text(
                            text = "My Trips",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 20.dp, start = 20.dp)
            ) {
                Row {
                    Text(text = "Categories")
                }

                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(5) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults
                                .buttonColors(
                                    containerColor = Color(0xFFCF06F0)
                                ),
                            modifier = Modifier
                                .height(80.dp)
                                .width(120.dp),
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row {
                                    Image(
                                        painterResource(id = R.drawable.montanha) ,
                                        contentDescription = "Montanhas",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                }

                                Row {
                                    Text(text = "Montain")
                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = searchState.value,
                    onValueChange = {
                        searchState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(24.dp)
                        ),
                    trailingIcon = {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search your destiny",
                                tint = Color(0xffA09C9C)
                            )
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Search your destiny",
                            color = Color(0xffA09C9C)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color(0xF6DDD5D5)
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            ) {
                Row {
                    Text(text = "Past Trips")
                }

                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(3) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .shadow(10.dp),
                            colors = CardDefaults
                                .cardColors(
                                    containerColor = Color.White
                                )
                        ) {
                            Image(
                                painterResource(id = R.drawable.londres),
                                contentDescription = "Paisagem de londres",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                            )

                            Column(
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding( bottom = 10.dp)
                                ) {
                                    Text(text = "London, 2019",
                                        color = Color(0xFFCF06F0))
                                }
                                Row(
                                    modifier = Modifier
                                        .padding( bottom = 10.dp)
                                ) {
                                    Text(text = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
                                        fontSize = 14.sp,
                                        color = Color(0xffA09C9C)
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 10.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = "18 Feb - 21 Feb",
                                        color = Color(0xFFCF06F0),
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {
        Greeting()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Tela2Preview() {
    MyTripsTheme {
        Tela2()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Tela3Preview() {
    MyTripsTheme {
        Tela3()
    }
}
