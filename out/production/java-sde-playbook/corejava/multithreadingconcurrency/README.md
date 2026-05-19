# Multithreading & Concurrency in Java

Concurrency is one of the most complex and frequently tested Java topics. It covers creating threads, synchronization, locks, thread pools, and concurrent data structures.

## Thread Basics

- Creating threads: extends Thread vs implements Runnable vs Callable
- Thread lifecycle: NEW → RUNNABLE → BLOCKED/WAITING/TIMED_WAITING → TERMINATED
- Thread methods: start(), join(), sleep(), interrupt(), yield()
- Daemon threads

## Synchronization

- synchronized keyword (method-level and block-level)
- Intrinsic locks (monitor locks)
- volatile keyword — visibility guarantee, prevents caching
- Happens-before relationship
- Deadlock, Livelock, Starvation

## java.util.concurrent Package

- Lock interface: ReentrantLock, ReadWriteLock (ReentrantReadWriteLock)
- Semaphore — controls access to a resource pool
- CountDownLatch — wait for N threads to finish
- CyclicBarrier — let N threads wait for each other at a barrier
- Phaser — flexible version of CyclicBarrier
- Exchanger — exchange data between two threads

## Thread Pools (Executor Framework)

- ExecutorService, Executors factory methods
- ThreadPoolExecutor — core pool size, max pool size, queue, rejection policy
- ScheduledExecutorService — delayed and periodic tasks
- Future and CompletableFuture (async programming, chaining)

## Concurrent Collections

- ConcurrentHashMap — segment-level locking (Java 7), CAS (Java 8+)
- CopyOnWriteArrayList — thread-safe reads, expensive writes
- BlockingQueue: ArrayBlockingQueue, LinkedBlockingQueue (producer-consumer)

## Interview Questions

- What is the difference between synchronized and ReentrantLock?
- What is a race condition and how do you prevent it?
- Explain volatile — does it guarantee atomicity?
- What is the difference between wait() and sleep()?
- How does ConcurrentHashMap achieve thread safety in Java 8?
- What is a ThreadLocal and when is it useful?
