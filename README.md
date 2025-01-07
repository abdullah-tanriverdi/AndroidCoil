# Coil Example Project for Android


**Description:**

This project demonstrates how to use Coil, a powerful image loading library for Android, to fetch and display images from remote URLs. It showcases the use of both `SubcomposeAsyncImage` (for Jetpack Compose) and `AsyncImage` (for traditional Android Views). The project also includes a button to clear the image cache (both memory and disk).

**Key Features:**

*   **Efficient Image Loading:** Utilizes Coil for optimized image fetching, decoding, and display, including features like memory and disk caching, downsampling, and automatic request pausing/canceling.
*   **Jetpack Compose Support:** Demonstrates seamless integration with Jetpack Compose using the `SubcomposeAsyncImage` composable.
*   **Traditional View Support (Minimal):** Shows basic usage of `AsyncImage` (though the primary focus is Compose).
*   **Cache Management:** Includes a "Clear Cache" button to remove cached images from both memory and disk, allowing you to test cache invalidation and reloading.
*   **Customizable Caching:** The `MyApplication` class demonstrates how to customize Coil's caching behavior, including setting maximum cache sizes and enabling strong references.
*   **Clear Code with Comments:** The codebase is well-commented to explain the functionality and usage of Coil.


**Usage:**

The application automatically fetches and displays two images from predefined URLs. Tapping the "Clear Cache" button will remove these images from Coil's cache. This allows you to observe how Coil reloads the images on subsequent attempts.

**Code Breakdown:**

*   **`MainActivity.kt`:** This activity sets up the UI using Jetpack Compose and utilizes Coil's `SubcomposeAsyncImage` to load and display images. It also handles the "Clear Cache" button's click event, triggering the cache clearing logic.

*   **`MyApplication.kt`:** This class extends `Application` and implements `ImageLoaderFactory`. It's responsible for configuring Coil's `ImageLoader`, including:

    *   Setting `memoryCachePolicy` and configuring the memory cache with `maxSizePercent` and `strongReferencesEnabled`.
    *   Setting `diskCachePolicy` and configuring the disk cache with `maxSizePercent` and the cache directory.
    *   Using a `DebugLogger` for debugging Coil's operations (useful during development).

**Dependencies:**

*   Coil: `implementation("io.coil-kt.coil3:coil-compose:3.0.4")` (or latest version)
*   Jetpack Compose (defined in your project's `build.gradle` file)

