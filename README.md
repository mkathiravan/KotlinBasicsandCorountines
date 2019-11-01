# KotlinBasicsandCorountines

# Kotlin Corountines:
Kotlin Coroutines are like lightweight threads. They are lightweight because creating coroutines doesn’t allocate new threads. Instead, they use predefined thread pools, and smart scheduling. Scheduling is the process of determining which piece of work you will execute next. Just like a regular schedule.

# Suspend Functions:
This kind of function can be suspended without blocking the current thread. Instead of returning a simple value, it also knows in which context the caller suspended it. Using this, it can resume appropriately, when ready.

# CoroutineBuilders:
These take a suspending lambda as an argument to create a coroutine. There are a bunch of coroutine builders provided by Kotlin Coroutines, including async(), launch(), runBlocking.

# CoroutineScope:
Helps to define the lifecycle of Kotlin Coroutines. It can be application-wide or bound to a component like the Android Activity. You have to use a scope to start a coroutine.

# CoroutineDispatcher:
Defines thread pools to launch your Kotlin Coroutines in. This could be the background thread pool, main thread or even your custom thread pool. You’ll use this to switch between, and return results from, threads

# CorountineJobs:
As the name suggests, a Job represents a piece of work that needs to be done. Additionally, every Job can be cancelled, finishing its execution. Because of that, it has a lifecycle and can also have nested children. Coroutine builders like launch() and async() return jobs as a result.


If you create a child for a Job, by nesting coroutines, it forms a parent-child hierarchy. With the hierarchy, you can control all the children through this single instance of a Job. If you cancel the parent, all of the children get canceled too. If a child fails in execution, the rest of the hierarchy fails, as well.


# Using Dispatchers With Kotlin Coroutines:

i) Dispatchers.Default: CPU-intensive work, such as sorting large lists, doing complex calculations and similar. A shared pool of threads on the JVM backs it.

ii) Dispatchers.IO: networking or reading and writing from files. In short – any input and output, as the name states

iii) Dispatchers.Main: recommended dispatcher for performing UI-related events. For example, showing lists in a RecyclerView, updating Views and so on.

Deferred is some kind of analog of Future in Java: in encapsulates an operation that will be finished at some point in future after it's initialization. But is also related to coroutines in Kotlin.
From documentation:
Deferred value is a non-blocking cancellable future — it is a Job that has a result.

Once you cancel a Job, you cannot reuse it for coroutines. You have to create a new one. This is why it’s a good practice to either avoid adding Jobs to the CoroutineContext of your scope, or to recreate jobs according to your app’s lifecycle.

In this project I explained how to use fragment adatper in kotlin and how to download the image and apply some images during the loading time using kotlin coroutines.

![image](https://user-images.githubusercontent.com/39657409/68041833-6dc10a00-fcf7-11e9-8b8c-0b16b4b61bea.png)

![image](https://user-images.githubusercontent.com/39657409/68041850-7d405300-fcf7-11e9-8e17-15cc2003e5da.png)

![image](https://user-images.githubusercontent.com/39657409/68041868-8b8e6f00-fcf7-11e9-93e3-3a89f5eecc3b.png)
