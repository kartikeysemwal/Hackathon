# Hackathon
**GitHub Username** : kartikeysemwal

# Serve

Description

**App is written solely in the Java Programming Language**

**Application gradle specification**

compileSdkVersion 28

minSdkVersion 19

targetSdkVersion 28

The application will run of about 90 percent of the smartphones present in India using these versions. The most stable version present right now is API level 29. The application fully supports all the features above the required specification.

Serve is application development for the rural India which is available for android. This application helps you track all the necessary information near you. Like employment in the nearby place, heath care services, daily bulletins, etc.

As this application is for the rural India it is multilingual currently available in Hindi and English and have a feature of tap to speak where clicking any button the application speaks about it.

The user can create an account and see all the necessary information.

Intended User

This application covers the rural people of India.

Features

Features of the application:

- Multilingual
- Speak Assistance
- Secure using firebase authentication
- Employment Search
- Daily Bulletin
- HealthCare

User Interface Mocks

**Screen 1**

![Screen 1](/images/Screen1.jpg)

**Screen 2**

![Screen 2](/images/Screen2.jpg)

**Screen 3**

![Screen 3](/images/Screen3.jpg)

**Widget**

![Widget](/images/Screen4.png)

Key Considerations

**How will your app handle data persistence? **

Data persistence is done using the firebase real time database.

**Describe any edge or corner cases in the UX.**

The application starts with the selection of language after which if you are a user you have to sign in otherwise create a account. When you are logged in you can select the desired option needed.

**Describe any libraries you&#39;ll be using and share your reasoning for including them.**

Google maps is used for various features. For daily bulletin either API for news will be taken or by using the html mark-up the news will be fetched.

**Describe how you will implement Google Play Services or other external services.**

Firebase service is used by google firebase. Google maps will be used which are easy to use as Android Studio have build in support.

Next Steps: Required Tasks

This is the section where you can take the main features of your app (declared above) and break them down into tangible technical tasks that you can complete one at a time until you have a finished app.

**Task 1: Project Setup**

A multilingual backend setup containing language inputs for various buttons.

Several audio will be required for serving the purpose.

**Task 2: Implement UI for Each Activity and Fragment**

- Build signup and login form.
- Simple and interactive UI so that it can be easily interpreted by the rural people.

**Task 3:**  **Backend for Options**

Use of API or website for news search. Firebase for displaying results for example job search or books present in the nearest library.

**Task 4:**  **Designing the Options**

As each option is different in itself a detailed design will be required to build them in a manner so that they can be simple to interpret.

**Task 5:**  **Features required for Build**

The app enables RTL layout switching on all layouts

As each option is different in itself a detailed design will be required to build them in a manner so that they can be simple to interpret.

All values will be kept in strings xml file.

As it has various options the API can either be used once to pull out all the data at once or can be used frequently in query operations.

Layout will be most of the time as simple as possible for the user as the target audience is the rural people in India who don&#39;t know much about the running of smartphones.

The accessibility is application is by touch. However, the application will respond to the task of the touch button using audio output which will help in building a touch assistance application. This is help in a better way to the audience.
