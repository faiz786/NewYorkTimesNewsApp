# NewYorkTimesNewsApp
A sample android app that shows how to use ViewModels and Room together with RxJava & Dagger Hilt, in Kotlin by Clean Architecture.

### Implemented by Clean Architecture
The following diagram shows the structure of this project with 3 layers:
- Presentation
- Domain
- Data

![MVVM](/screenshots/CleanArchitecture.png)

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case gets data from News Repository.
4. Each Repository returns data from a Data Source (Cached or Remote).
5. Information flows back to the UI where we display the list of news.



### Scenario
Used [NY Times API](https://developer.nytimes.com/)  api to get news


## Libraries


Libraries used in the whole application are:

- [Jetpack](https://developer.android.com/jetpack)🚀
    - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way
      and act as a channel between use cases and ui
    - [View Binding](https://developer.android.com/topic/libraries/data-binding) - View binding is a feature that allows you to more easily write code that interacts with views
    - [Room](https://developer.android.com/training/data-storage/room) - Provides abstraction layer over SQLite
    - [Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started) - Navigation support for Android
- [Retrofit](https://square.github.io/retrofit/) - type safe http client and supports coroutines out of the box
- [Gson](https://github.com/square/moshi) - Library that can be used to convert Kotlin Objects into/from their JSON representation
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Threads on steroids for Kotlin
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
- [Espresso](https://developer.android.com/training/testing/espresso) - Test framework to write UI Tests
- [mockK](https://mockk.io/) - Mocking framework that comprehensively supports Kotlin features
- [JUnit Rules](https://developer.android.com/training/testing/instrumented-tests/androidx-test-libraries/rules) - JUnit rules provide more flexibility and reduce the boilerplate code required in tests
- [Glide](https://github.com/bumptech/glide) - Media management and image loading framework for Android
- [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Rx-Java](https://github.com/ReactiveX/RxJava)a library for composing asynchronous and event-based programs by using observable sequences