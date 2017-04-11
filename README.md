# challengeContactList

App in Java: Challenge Contact List

Develop a contact list using the JSON data provided via this endpoint. The data should be downloaded, parsed and displayed in a listview. If the user taps on one of the contacts, the application should navigate to a detail view.

## Libraries

### Fresco - Image managment library
### Retrofit - Http client
### Gson Converter - Serialization/deserialization library

## Notes

### I've used RecyclerView instead of ListView because of this:

The RecyclerView widget is a more advanced and flexible version of ListView. This widget is a container for displaying large data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.
The RecyclerView class simplifies the display and handling of large data sets by providing:
- Layout managers for positioning items
- Default animations for common item operations, such as removal or addition of items
- You also have the flexibility to define custom layout managers and animations for RecyclerView widgets

### I've done two layouts of contact list details, one for wide screen and the other for handset device, because of this:

Flexible UI: When designing your application to support a wide range of screen sizes, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. For example, on a handset device it might be appropriate to display just one fragment at a time for a single-pane user interface. Conversely, you may want to set fragments side-by-side on a tablet which has a wider screen size to display more information to the user.
