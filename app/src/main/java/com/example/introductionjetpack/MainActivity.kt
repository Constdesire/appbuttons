package com.example.introductionjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introductionjetpack.ui.theme.DebugButtonColors
import com.example.introductionjetpack.ui.theme.ErrorButtonColor
import com.example.introductionjetpack.ui.theme.InfofulButtonColor
import com.example.introductionjetpack.ui.theme.IntroductionjetpackTheme
import com.example.introductionjetpack.ui.theme.WarningButtonColor

const val TAG = "Text Android"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionjetpackTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}
    @Composable
    fun App(){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
            ){

            Greeting("JetPack")
            ActionButton(
                text = "Debug",
                buttoncolors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
             Log.d(TAG,"App: Clicou em Debug!!")
            }
                ActionButton(
                    text = "info",
                    buttoncolors = InfofulButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Log.i(TAG,"App: Clicou em Info!!")
                }
                ActionButton(
                    text = "Warning",
                    buttoncolors = WarningButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Log.w(TAG,"App: Clicou em Warning!!")
                }
                ActionButton(
                    text = "Erro",
                    buttoncolors = ErrorButtonColor(),
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Log.e(TAG,"App: Clicou em Erro!!")
            }
        }
     }
}

    @Preview(showBackground = true, widthDp = 150, heightDp = 200)
    @Composable
    fun AppPreview() {
        IntroductionjetpackTheme {
            App()
        }
    }

@Composable
fun ActionButton(
    text: String,
    buttoncolors:ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block:() -> Unit
){
ElevatedButton(
    onClick = block,
    shape = RoundedCornerShape(5.dp),
    colors = buttoncolors,
    modifier = modifier
) {
    Text(text = text)
}
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
        
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroductionjetpackTheme {
        Greeting("JetPack")
    }
}