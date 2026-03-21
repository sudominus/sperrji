# sperrji

Minimal Android app that locks the screen using the accessibility global action `GLOBAL_ACTION_LOCK_SCREEN`. It includes a transparent, resizable home screen widget and a launcher shortcut.

**Requirements:** Android 9 (API 28) or newer.

## Setup

1. Install the APK (see [CI](#ci) or [Releases](#releases)).
2. Open **Settings → Accessibility** and enable **sperrji**.
3. Use either:
   - **App icon** — opens the app; if the service is enabled, the screen locks. If not, use the button to open accessibility settings, then return; the app will try to lock when you come back.
   - **Widget “sperrji lock”** — add it to the home screen, resize as needed (it stays visually empty/transparent), tap to lock.

If the service is off, the widget shows a short message when tapped.

## Building locally

- Install [Android Studio](https://developer.android.com/studio) or the Android SDK and set `sdk.dir` in `local.properties` (see [Android Gradle docs](https://developer.android.com/studio/build#properties-files)).
- JDK 17.

```bash
./gradlew assembleDebug
# or
./gradlew assembleRelease
```

Debug output: `app/build/outputs/apk/debug/app-debug.apk`.  
Release output: `app/build/outputs/apk/release/app-release.apk`.

The release build is signed with the debug keystore so sideloading works without extra keys (suitable for personal use; use your own keystore for Play distribution).

## CI

On every **push** and **pull request**, GitHub Actions runs `assembleRelease` and uploads an artifact **`sperrji-release-apk`** containing `app-release.apk` (retention 90 days). Download it from the workflow run’s **Artifacts** section.

## Releases

Pushing a version tag matching **`v*.*.*`** (for example `v1.0.0`) builds the release APK and creates a **GitHub Release** with generated notes and an asset named `sperrji-<tag>.apk`.

```bash
git tag v1.0.0
git push origin v1.0.0
```

## Privacy

The accessibility service does not collect or upload data; it only exists so the app can request the system lock action when you use the launcher or widget.
