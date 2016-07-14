# Bases


## About
Bases is a set of activities and fragments using [butterknife 7.0.1](https://github.com/JakeWharton/butterknife) and [InjectLayout](https://github.com/jgabrielfreitas/injectlayout)
to make development productivity.

## Usages

#### For simple activities

```java
@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity {

}
```
#### Methods

| Method        | Do            | Note       |
| ------------- |:------------- |:-----------|
|modifyViews()  | method to modify your views. Ex: set text for any TextView| Called on `onStart()` |
|doIntent(classToIntent)  | do `Intent` for any `Activity`| --- |
|doIntent(classToIntent, parcelable)  | do `Intent` for any `Activity` with parcelable object | you can get the parcelable object using the `getParcelableObject()` |
|doIntent(classToIntent, requestCode)  | do `Intent` for any `Activity` with a requestCode | this method will call `startActivityForResult` |
|doIntent(classToIntent, parcelable, requestCode)  | do `Intent` for any `Activity` with parcelable object and a requestCode | this method will call `startActivityForResult` |
|closeKeyboard() | hide the keyboad | --- |
|addFragmentAtStack(fragmentToReplace) | add an `BaseFragment` in stack | --- |
|replaceFragment(fragmentToReplace) | replace an `BaseFragment` in stack | --- |
|killThisActivity() | call `finish()` | --- |
|loge(toLog) | show a `Log.e` in `LogCat` | --- |
|logi(toLog) | show a `Log.i` in `LogCat` | --- |
|configToolbarBackButton(toolbar) | If you're using a custom toolbar (not ActionBar), put a back arrow and close on click | --- |

#### Variables
| Variables        | What is            | Note       |
| ------------- |:------------- |:-----------|
| containerId | ID from fragments container | --- |
| animationOnIntent | if you want create a custom animation on intent | override `animIn` and `animOut` |
| killAfterIntent | kill your activity after `doIntent` is called | default is true, you can override this in `onCreate` |


#### For activities with dialogs 

> `BaseWithDialogActivity extends BaseActivity`

```java
@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseWithDialogActivity {

}
```
#### Methods

| Method        | What is      | Note       |
| ------------- |:------------- |:-----------|
|showProgress()  | show a `ProgressDialog` with message  | call `showProgress(message)` passing progressDialogMessage | 
|showProgress(message)| show a `ProgressDialog` with message| --- |
|dismissDialog()| close the `ProgressDialog` | --- |

#### Variables
| Variables        | Do            | Note       |
| ------------- |:------------- |:-----------|
|progressDialogMessage| message to show in `showProgress()` and `showProgress(message)` | --- |


---

#### For fragments

```java
@InjectLayout(layout = R.layout.fragment_main)
public class MainFragment extends BaseFragment {

}
```

#### Methods

| Method        | Do            | Note       |
| ------------- |:------------- |:-----------|
|modifyViews()  | method to modify your views. Ex: set text for any TextView| Called on `onStart()` |
|getFlipBaseActivity()  | return a `BaseActivity` | --- |
|closeKeyboard() | hide the keyboad | --- |

