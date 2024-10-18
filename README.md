  WeatherApp 🌤️   

A simple Android app that allows users to get real-time weather information by entering a city name. This app fetches weather data from the OpenWeatherMap API and displays weather details, including temperature and an icon representing the weather condition. 

 

Features  

🌐 Real-time Weather Data: Fetch current temperature and weather description for any city.   

🌍 Location Support: Uses both coarse and fine location permissions (optional).   

🖼️ Weather Icons: Displays dynamic weather icons based on the forecast.   

📱 Material UI: Simple, clean, and modern user interface. 

 

Technologies Used 

Android Studio (Kotlin)   

OpenWeatherMap API for weather data   

Retrofit for network operations   

Glide for loading weather icons   

Gradle for dependency management   

 

Prerequisites   

Before running the app, ensure you have the following installed: 

 Android Studio (latest version)   

An emulator or Android device with internet access   

A valid API key from OpenWeatherMap (https://openweathermap.org/) 

  

Setup and Installation 

  

Clone the repository: 

   Bash 

git clone  https://github.com/noormuniruet/WeatherApp.git    

Open the project in Android Studio 

Add your OpenWeatherMap API key: 

In MainActivity.kt, replace YOUR_API_KEY with your valid API key 

kotlin 

     val apiKey = "YOUR_API_KEY" 

Sync the Gradle files: 

Go to File > Sync Project with Gradle Files. 

 Run the app on an emulator or physical device. 

  

API Integration 

This project uses OpenWeatherMap API to fetch weather data. Below is an example of a JSON response  

  

json 

{ 

  "weather": [ 

    { 

      "id": 800, 

      "main": "Clear", 

      "description": "clear sky", 

      "icon": "01d" 

    } 

  ], 

  "main": { 

    "temp": 25.32, 

    "feels_like": 25.6, 

    "humidity": 60 

  } 

} 

 

Dependencies 

 In your build.gradle.kts (app level) file, ensure the following dependencies are added:   

 groovy 

dependencies { 

implementation ("com.squareup.retrofit2:retrofit:2.9.0") 
implementation ("com.squareup.retrofit2:converter-gson:2.9.0") 
implementation ("com.github.bumptech.glide:glide:4.11.0") 
implementation ("com.google.android.gms:play-services-location:21.0.1") 
implementation ("androidx.appcompat:appcompat:1.6.1") 
implementation ("com.google.android.material:material:1.9.0") 

 

} 

  

Permissions Used  

The app requires the following permissions: 

 INTERNET: To fetch weather data from the API.   

ACCESS_FINE_LOCATION: (Optional) To get weather data for the current location.   

ACCESS_COARSE_LOCATION: (Optional) To access approximate location. 

  

xml 

<uses-permission android:name="android.permission.INTERNET" /> 
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" /> 
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" /> 

 

How It Works 

1. User enters a city name in the text field. 

2. The "Get Weather" button triggers an API request to OpenWeatherMap. 

3. The app displays: 

Current temperature   

Weather description 

 Icon representing the weather condition 

4. If the city is not found or there's an error, an appropriate message is displayed. 

 

Known Issues and Solutions 

App Crashing due to Theme Issues:   

 Ensure the correct theme Theme.AppCompat is applied in themes.xml and referenced in AndroidManifest.xml. 

 Invalid API Key Error:   

Double-check the API key in MainActivity.kt. If needed, generate a new key from OpenWeatherMap. 

  

Contributing 

Feel free to open issues or submit pull requests if you want to contribute to this project. Any contributions are welcome! 

 

Contact 

If you have any questions or issues with the project, feel free to contact me:   

Email: noorfatimagrw965@gmail.com 

    

  

  

 
