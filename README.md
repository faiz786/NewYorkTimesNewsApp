# ArtGallery
A sample android app that shows how to use ViewModels and Room together with RxJava & Dagger2, in Kotlin by Clean Architecture.

### Implemented by Clean Architecture
The following diagram shows the structure of this project with 3 layers:
- Presentation
- Domain
- Data

![MVVM](/screenshots/CleanArchitecture.png)

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case combines data from Album and Photo Repositories.
4. Each Repository returns data from a Data Source (Cached or Remote).
5. Information flows back to the UI where we display the list of posts.



### Scenario
Used [NY Times API](https://developer.nytimes.com/)  api to get news
