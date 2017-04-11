# Challenge Contact List
Develop a contact list using the JSON data provided via this endpoint. The data should be downloaded, parsed and displayed in a listview. If the user taps on one of the contacts, the application should navigate to a detail view.

# Libraries
- [Fresco](http://frescolib.org/) - Image managment library
- [Retrofit](http://square.github.io/retrofit/) - Http client
- Gson Converter - Serialization/deserialization library 

# Considerations
- I've used [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html) instead of ListView because of  [this](https://developer.android.com/training/material/lists-cards.html) and [this](http://stackoverflow.com/a/28886129).
- I've done two layouts of contact list details, one for wide screen (We can take advantage of large screen size) and the other for  handset device. [Why?](https://developer.android.com/training/basics/fragments/fragment-ui.html)
