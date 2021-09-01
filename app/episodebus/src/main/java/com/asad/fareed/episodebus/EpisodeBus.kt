package com.asad.fareed.episodebus

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject
import io.reactivex.disposables.Disposable


object EpisodeBus{

    private  val publisher = PublishSubject.create<Any>()

    fun postEpisode(episode: Any) {
        publisher.onNext(episode)
    }

    fun observeEpisode(): Observable<Any> {
        return publisher
    }

}