package com.asad.fareed.myepisodebus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asad.fareed.episodebus.EpisodeBus
import com.asad.fareed.myepisodebus.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        EpisodeBus.observeEpisode().subscribe(episodeObserver)
    }

    override fun onResume() {
        super.onResume()
        EpisodeBus.postEpisode(Episode("Data class string"))
    }

    override fun onPause() {
        super.onPause()
        EpisodeBus.postEpisode("Simple String")
    }

    private val episodeObserver = object : Observer<Any>{
        override fun onSubscribe(d: Disposable) {
            // Not Implemented
        }

        override fun onNext(t: Any) {
            if(t is Episode){
                binding.tv.text = t.message
            }else if(t is String){
                binding.tv.text = t
            }
        }

        override fun onError(e: Throwable) {
            // Not Implemented
        }

        override fun onComplete() {
            // Not Implemented
        }
    }

    data class Episode(
        val message:String
    )
}