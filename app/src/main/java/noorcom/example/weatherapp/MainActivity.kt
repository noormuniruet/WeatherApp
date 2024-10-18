package noorcom.example.weatherapp
import WeatherResponse
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import noorcom.example.weatherapp.ui.theme.WeatherAppTheme
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var etCityName: EditText
    private lateinit var btnFetchWeather: Button
    private lateinit var tvWeatherData: TextView
    private lateinit var ivWeatherIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCityName = findViewById(R.id.etCityName)
        btnFetchWeather = findViewById(R.id.btnFetchWeather)
        tvWeatherData = findViewById(R.id.tvWeatherData)
        ivWeatherIcon = findViewById(R.id.ivWeatherIcon)

        btnFetchWeather.setOnClickListener {
            val city = etCityName.text.toString()
            if (city.isNotEmpty()) {
                fetchWeatherData(city)
            } else {
                tvWeatherData.text = "Please enter a city name"
            }
        }
    }

private fun fetchWeatherData(city: String) {
    val apiKey = "YOUR API KEY" // Replace with your valid API key
    RetrofitInstance.api.getWeatherData(city, apiKey).enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(
            call: Call<WeatherResponse>,
            response: Response<WeatherResponse>
        ) {
            if (response.isSuccessful && response.body() != null) {
                val weather = response.body()
                weather?.let {
                    val temp = it.main.temp
                    val description = it.weather[0].description
                    val icon = it.weather[0].icon

                    runOnUiThread {
                        tvWeatherData.text = "Temperature: $temp°C\nDescription: $description"
                        val iconUrl = "https://openweathermap.org/img/wn/${icon}@2x.png"
                        Glide.with(this@MainActivity).load(iconUrl).into(ivWeatherIcon)
                    }
                }
            } else {
                runOnUiThread {
                    tvWeatherData.text = "City not found or invalid response"
                }
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            runOnUiThread {
                tvWeatherData.text = "Error: ${t.message}. Check your network connection."
            }
        }
    })
}

}
