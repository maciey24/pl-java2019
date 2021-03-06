# RxJava in legacy projects - live coding session

Introduction to reactive programming - https://gist.github.com/staltz/868e7e9bc2a7b8c1f754

Rough agenda follows:

## `CompletableFuture`

Similarities

## Introduction to RxJava

## `Observable.fromCallable()`

* wrap business methods, laziness

## `Observable.timeout()`

## `Observable.subscribeOn()`

* custom thread pool
* parallelize `PersonDao` and `WeatherClient` with `zipWith()`

## `Observable.toBlocking()`

## `Observable.merge()`, `first()`

* `CacheServer` x2

## `Observable.interval()`, `distinct()`

* Polling for file system changes
* Potential memory leak, RxJava 2.0, `distinctUntilChanged()`

## `TestScheduler` (test timeouts)

* `timeout()`, `retry()`, `doOnError()`
* `assertNoValues()`, `assertNoErrors()`

## `Observable.flatMap()`

* Parallel fetching of URLs

## `Observable.interval()`, `window()`

* `Pinger`, sliding window of `Status` instances
