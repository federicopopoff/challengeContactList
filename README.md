# Challenge Contact List

App in Java with Android Studio

I develop a contact list using the JSON data provided via this endpoint ("https://s3.amazonaws.com/technical-challenge/Contacts.json"). The data should be downloaded, parsed and displayed in a listview. If the user taps on one of the contacts, the application navigate to a detail view.

## Libraries I used

### Retrofit - Http client

Retrofit is a type-safe REST client for Android (or just Java) developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. See this guide to understand how OkHttp works.

### Fresco - Image managment library

Fresco takes care of image loading and display, so you don't have to. It will load images from the network, local storage, or local resources, and display a placeholder until the image has arrived. It has two levels of cache; one in memory and another in internal storage.

### Gson Converter - Serialization/deserialization library

Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.

## Notes

### I've used RecyclerView instead of ListView because of this:

The RecyclerView widget is a more advanced and flexible version of ListView. This widget is a container for displaying large data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.
The RecyclerView class simplifies the display and handling of large data sets by providing:
- Layout managers for positioning items
- Default animations for common item operations, such as removal or addition of items
- You also have the flexibility to define custom layout managers and animations for RecyclerView widgets

### I've done two layouts of contact list details, one for wide screen and the other for handset device, because of this:

Flexible UI: When designing your application to support a wide range of screen sizes, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. For example, on a handset device it might be appropriate to display just one fragment at a time for a single-pane user interface. Conversely, you may want to set fragments side-by-side on a tablet which has a wider screen size to display more information to the user.

## Built With

* [Android Studio](https://developer.android.com/studio/index.html?hl=es-419) - The IDE for Android Apps. 

## Authors

* **Federico Popoff** - *Initial work* - [federicopopoff](https://gist.github.com/federicopopoff/)
