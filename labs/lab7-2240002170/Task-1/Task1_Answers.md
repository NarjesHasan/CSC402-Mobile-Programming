# Task 1 - Reading the old View/Fragment implementation

- XML is inflated by setContentView(R.layout.activity_rate).
- label.text = ... is imperative because code directly mutates a View property.
- addToBackStack("news") lets Back return to the previous Activity content; without it, replacing the Fragment does not retain that screen on the Fragment back stack.
- Compose mapping: RatingBar -> AndroidView wrapper; second Activity and findViewById -> Compose route/screen; label mutation -> state-driven Text; news Fragment -> WebView in AndroidView; Fragment transaction/back stack -> NavHost route navigation.
