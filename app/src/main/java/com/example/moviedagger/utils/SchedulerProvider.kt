package com.example.moviedagger.utils

import io.reactivex.Scheduler


interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}