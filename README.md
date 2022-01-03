
<p align="center">
<p>

## CryptoInfo(For code switch to master branch)! :moneybag: :arrow_right: :iphone: 

## DESCRIPTION

Cryptocurrency App with MVVM design pattern to track all the coins data and other informatoion in realtime for android. Written in Kotlin using Android SDK. Please don't forget to give stars so that i keep updating the project.

## FEATURES

This Application allows users to view Cryptocurrency prices and monitor their rise and drop.
  
- Built Cryptoinfo application with necessary Cryptocurries regarding information by leveraring the benefits of several public apis.
  
- User can **View Lists of Cryptocurrencies** ***with their prices.*** as well as all detailed information regarding team members, tags etc.
  
- User can explore all the related web references with respect to each coin.
  
- Calculator to covert and calculate cryptocurries to **USD** in using realtime crypto value.
  
## INSPIRATION

Recently i got interested in Digital Currency Specifically cryptocurrency.

I believe Blockchain Technology might be the Second best invention after the Internet, also i wanted to learn blaockchain but i need to first master Native android development then i will definitly give it a shot.

**However Lets Talk Code!** :computer:

**This project** came to mind, and i thought that let's build something regarding cryptocurrncies, then i came across several public apis.

I wanted to **challenge myself** with code as I tried to build this app as clean as possible and i will try my best to optimize the code, i have used **Coroutines**, **MVVM**, **Livedata** and other **best practices**.

Further this is not completed yet but i am daily working on this thing.

## PRE-REQUISITES.

A couple of things to get you started:

1. Ensure you have [Java](https://java.com/en/download/) installed

A simple way to install Java is using [sdkman](https://sdkman.io/).

Simply follow the instructions to have _sdkman_ installed and install java:

```bash
sdk install java
```

2. [Gradle](https://gradle.org/)

Gradle is used as the build tool and can be installed with sdkman:

```bash
sdk install gradle
```

3. [Android SDK](https://developer.android.com/studio/)

Android SDK used to provide all the necessary developer tools to build, test, and debug apps for Android in Windows, Mac or Linux.

4. [Android Build Tools](https://developer.android.com/studio/releases/build-tools)

Android SDK build tools used to debug, build, run and test an Android application.


### IMPORTANT TERMS TO TAKE NOTE. :smiley:

**Some Basic knowlegde useful to understanding the project or just for fun**

**What is the "Value of Bitcoin" ?**

The ***Value of Bitcoin*** is actually the trust and utility of the Bitcoin network itself. In reality its just worth what someone is willing to pay for it.

**What is "Market Capitalization" and how is it calculated?**

***Market Capitalization*** is one way to rank the relative size of a cryptocurrency. It's calculated by multiplying the Price by the Circulating Supply.

Market Cap = Price X Circulating Supply.

**What is "Circulating Supply"**

***Circulating Supply*** is the best approximation of the number of coins that are circulating in the market and in the general public's hands.

**What is "Total Supply"**

***Total Supply*** is the total amount of coins in existence right now (minus any coins that have been verifiably burned).

- **What is "Max Supply"**

***Max Supply*** is the best approximation of the maximum amount of coins that will ever exist in the lifetime of the cryptocurrency.
  
 #### OnBoarding Page.

<p align="center">
<img align="left" width="250" src="https://user-images.githubusercontent.com/72120614/147904327-ca480f2c-2f65-404f-bf93-9f73361d21e7.jpg"  />
<img align="centre" width="250" src="https://user-images.githubusercontent.com/72120614/147903646-4d155391-4b9a-4a64-aa61-d9a8b2d4e4cf.jpg"  />
<img align="right" width="250" src="https://user-images.githubusercontent.com/72120614/147903663-2f5aae98-6ab0-4b80-ba93-164764cac36a.jpg" />
<p>

#### DeatailsScreens.

<p align="center">
<img align="left" width="250" src="https://user-images.githubusercontent.com/72120614/147903788-2d41a615-52bd-4c94-90ff-05da322f7f9f.jpg"  />
<img align="centre" width="250" src="https://user-images.githubusercontent.com/72120614/147903795-68f12da2-0fbc-4c01-863e-f0b0da33ac57.jpg"  />
<img align="right" width="250" src="https://user-images.githubusercontent.com/72120614/147904389-45e6290c-2f0e-4f81-8d2d-14e80ac2e95a.jpg"  />

<p>


#### Calculator.

<p align="center">
<img align="left" width="250" src="https://user-images.githubusercontent.com/72120614/147903823-9fc4c923-d297-423f-86e5-3fdbfc9ba040.jpg" />
<img align="centre" width="250" src="https://user-images.githubusercontent.com/72120614/147903832-c2f19e8b-237e-49ca-9aa4-b66f001d04aa.jpg" />
<img align="right" width="250" src="https://user-images.githubusercontent.com/72120614/147903842-1944f929-4b2c-4721-b6f8-1147958fa16c.jpg" />
<p>



## TECHNOLOGIES USED:

4. **[Android SDK](https://developer.android.com/studio/)**

**For providing all the necessary developer tools to build, test, and debug Android applications on Windows, Mac or Linux.**

5. **[Android Build Tools](https://developer.android.com/studio/releases/build-tools)**

**For debugging, building, running and testing an Android applications.**

6. **[Coin Market Cap API](https://coinmarketcap.com/api/documentation/v1/)**

**Coin Market Cap** is a platform which provides fast, reliable and unified data APIs to cryptocurrency markets.

**Coin Market API** was used to get price listings on cryptocurrencies based on trade volume and market capitalization.

For more info about the API check out the API Section below.

## LIBRARIES TO NOTE.

1. **[GSON](https://github.com/google/gson)**

- **GSON was used in the API to convert Java Objects into JSON and back**

- Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a **JSON string** to an **equivalent** **Java object**. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source code of.

2. **[Retrofit](https://square.github.io/retrofit/)**

- A type-safe HTTP client for Android and Java.

3. **[Picasso](https://github.com/square/okhttp)**

- Picasso was used to display cryptocurrency logos.

- **Picasso** is an image library for **Android**.It caters to image loading and processing. It simplifies the process of displaying images from external locations

4. **[MVVM architecture](https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide)**

- MVVM architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component. 
  
- Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.
  
## COIN MARKET CAP API

***Coin Market API*** Provides crypto market data endpoints **market price listing based on trade volume and market capitalization**.

For CryptoByte **Gson components were used to parse JSON into Java objects**.

***Gson*** is an open source **Java library to serialize and deserialize Java objects to JSON**.

The benefit you get with GSON is that ***object mapping can save the time spent writing code***.


## **SETUP/INSTALLATION!**

1. You will need **Internet connection**.

2. You need to get into the **crypto-info**.

Link:-> ```https://github.com/ThakurVibha/crypto-info.git```

3. From there you can access **CryptoInfo**.

4. **Clone** the project.

5. **get into project folder** (cd into project).

6. If you have all the **Pre-requisites**

7. Open your **Android Studio Editor and run the Application**.


