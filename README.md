# MobCategories

Brief Overview: The application can consist of two pages:
- List page:
    - The list page should contain a list with products categorized per category.
    - Each item in the list should display full name and thumbnail of the image (if present).
    - Clicking an item will cause the application to open the detail view.

- Detail page:
  The detail page should display the following information of the selected product:
    - Name of the product.
    - Image with bigger view.
    - Price of the product.

# Language
- Kotlin

## Architecture

Android Model-View-ViewModel (MVVM) design architecture with the Repository
pattern.


# Libraries Used
- `Koin` - Dependency injection
- `Retrofit` - Making network request
- `Coroutines` - Asynchronous processing
- `Glide` - Image Loading
- `Mockito` - Mocking dependencies during `unit test`

## Tests
This app was built with testability in mind.


## Extras
- Data was obtained from `http://mobcategories.s3-website-eu-west-1.amazonaws.com`