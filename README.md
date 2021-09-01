[![](https://jitpack.io/v/asadfareed777/EpisodeBus.svg)](https://jitpack.io/#asadfareed777/EpisodeBus)


# MyEpisodeBus
 Episode Bus is a new way of communication
 
 
 Using Episode Bus, Activity and Fragments can communicate very easily. This library is very simple and beginners can use it very easily. This library uses RxJava's PublishSubject to create Observerables. 
 > Pardon my English
 
 # Implementation
 
 There are 3 steps to utilize this library
 
 # Step 1 : Add below dependencies in build.gradle Module
 
 Add it in your root build.gradle(Project)
 ```
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
  Add it in your root build.gradle(Module)
 ```
    // RxJava2 Dependencies
    implementation 'io.reactivex.rxjava2:rxjava:2.2.18'
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
    // library dependency
    implementation 'com.github.asadfareed777:EpisodeBus:Tag'  //Tag is latest version of library
 ```   
 # Step 2 : Post Episode from fragment, Adapter etc
 
 Example 1
 ```
 EpisodeBus.postEpisode("Simple String") 
 ```
 // Here episode is just a simple string (I recommend using data class for better usage)
 
 Example 2
 ```
 EpisodeBus.postEpisode(Episode("Data class string"))
 ```
 // Here episode is a data class 
 ```
 data class Episode(
        val message:String
    )
 ```
You can use custom data classes as episodes to get desired results

# Step 3 : Subscribe Observer in desired fragment etc to receive published episodes
```
EpisodeBus.observeEpisode().subscribe(episodeObserver) // here episodeObserver is observer to receive episodes
```
Finally define an observer
```
private val episodeObserver = object : Observer<Any>{
        override fun onSubscribe(d: Disposable) {
            // Not Implemented
        }

        override fun onNext(t: Any) {
            if(t is Episode){
                binding.textViewMessage.text = t.message
            }else if(t is String){
                binding.textViewMessage.text = t
            }
        }

        override fun onError(e: Throwable) {
            // Not Implemented
        }

        override fun onComplete() {
            // Not Implemented
        }
    }
 ```
 That's all for now. If you have any suggestion/question please reach out to me at asadfareed047@gmail.com. I would love to improve this library.
