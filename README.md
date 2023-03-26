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
