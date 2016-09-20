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

## How to
**Step 1.** Add the JitPack repository to your build file
```gradle
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
}
```

**Step 2.** Add the dependency
```gradle
dependencies {
		compile 'com.github.jgabrielfreitas:Bases:0.0.1'
}
```



# Licenses

```
The MIT License (MIT)

Copyright (c) 2016 João Gabriel de Freitas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Copyright 2013 Jake Wharton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


