package basic.thread.aqs;

/**
 * (1)AQS原理： AQS核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。
 * 如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，这个机制AQS是用CLH队列锁实现的，即将暂时获取不到锁的线程加入到队列中。
 *
 * (2)AQS定义两种资源共享方式
 *
 * Exclusive（独占）：只有一个线程能执行，如ReentrantLock。又可分为公平锁和非公平锁： 公平锁：按照线程在队列中的排队顺序，先到者先拿到锁
 * 非公平锁：当线程要获取锁时，无视队列顺序直接去抢锁，谁抢到就是谁的 Share（共享）：多个线程可同时执行，如Semaphore/CountDownLatch。Semaphore、CountDownLatCh、
 * CyclicBarrier、ReadWriteLock 我们都会在后面讲到。
 *
 * ReentrantReadWriteLock 可以看成是组合式，因为ReentrantReadWriteLock也就是读写锁允许多个线程同时对某一资源进行读。
 *
 * 不同的自定义同步器争用共享资源的方式也不同。自定义同步器在实现时只需要实现共享资源 state 的获取与释放方式即可， 至于具体线程等待队列的维护（如获取资源失败入队/唤醒出队等），AQS已经在上层已经帮我们实现好了。
 *
 * (3)AQS底层使用了模板方法模式 同步器的设计是基于模板方法模式的，如果需要自定义同步器一般的方式是这样（模板方法模式很经典的一个应用）：
 * 使用者继承AbstractQueuedSynchronizer并重写指定的方法。（这些重写方法很简单，无非是对于共享资源state的获取和释放）
 * 将AQS组合在自定义同步组件的实现中，并调用其模板方法，而这些模板方法会调用使用者重写的方法。
 *
 * 这和我们以往通过实现接口的方式有很大区别，这是模板方法模式很经典的一个运用，下面简单的给大家介绍一下模板方法模式，模板方法模式是一个很容易理解的设计模式之一。
 * 模板方法模式是基于”继承“的，主要是为了在不改变模板结构的前提下在子类中重新定义模板中的内容以实现复用代码。 举个很简单的例子假如我们要去一个地方的步骤是：购票buyTicket()->安检securityCheck()->乘坐某某工具回家ride()->到达目的地arrive()。我们可能乘坐不同的交通工具回家比如飞机或者火车，所以除了ride()方法，其他方法的实现几乎相同。我们可以定义一个包含了这些方法的抽象类，然后用户根据自己的需要继承该抽象类然后修改
 * ride()方法。 AQS使用了模板方法模式，自定义同步器时需要重写下面几个AQS提供的模板方法：
 *
 * isHeldExclusively()//该线程是否正在独占资源。只有用到condition才需要去实现它。 tryAcquire(int)//独占方式。尝试获取资源，成功则返回true，失败则返回false。
 * tryRelease(int)//独占方式。尝试释放资源，成功则返回true，失败则返回false。 tryAcquireShared(int)//共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
 * tryReleaseShared(int)//共享方式。尝试释放资源，成功则返回true，失败则返回false。
 *
 * 默认情况下，每个方法都抛出 UnsupportedOperationException。 这些方法的实现必须是内部线程安全的，并且通常应该简短而不是阻塞。 AQS类中的其他方法都是final
 * ，所以无法被其他类使用，只有这几个方法可以被其他类使用。
 *
 * 以ReentrantLock为例，state初始化为0，表示未锁定状态。A线程lock()时，会调用tryAcquire()独占该锁并将state+1。
 * 此后，其他线程再tryAcquire()时就会失败，直到A线程unlock()到state=0（即释放锁）为止，其它线程才有机会获取该锁。
 * 当然，释放锁之前，A线程自己是可以重复获取此锁的（state会累加），这就是可重入的概念。但要注意，获取多少次就要释放多么次，这样才能保证state是能回到零态的。
 *
 * 再以CountDownLatch以例，任务分为N个子线程去执行，state也初始化为N（注意N要与线程个数一致）。 这N个子线程是并行执行的，每个子线程执行完后countDown()一次，state会CAS(Compare
 * and Swap)减1。 等到所有子线程都执行完后(即state=0)，会unpark()主调用线程，然后主调用线程就会从await()函数返回，继续后余动作。
 *
 * 一般来说，自定义同步器要么是独占方法，要么是共享方式，他们也只需实现tryAcquire-tryRelease、tryAcquireShared-tryReleaseShared中的一种即可。
 * 但AQS也支持自定义同步器同时实现独占和共享两种方式，如ReentrantReadWriteLock。
 *
 * (4)CyclicBarrier和CountDownLatch的区别
 *
 * CountDownLatch是计数器，只能使用一次，而CyclicBarrier的计数器提供reset功能，可以多次使用。
 * 但是我不那么认为它们之间的区别仅仅就是这么简单的一点。我们来从jdk作者设计的目的来看，javadoc是这么描述它们的：
 *
 * CountDownLatch: A synchronization aid that allows one or more threads to wait until a set of operations
 * being performed in other threads completes.(CountDownLatch: 一个或者多个线程，等待其他多个线程完成某件事情之后才能执行；)
 *
 * CyclicBarrier : A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
 * (CyclicBarrier : 多个线程互相等待，直到到达同一个同步点，再继续一起执行。)
 *
 * 对于CountDownLatch来说，重点是“一个线程（多个线程）等待”，而其他的N个线程在完成“某件事情”之后，可以终止，也可以等待。
 * 而对于CyclicBarrier，重点是多个线程，在任意一个线程没有完成，所有的线程都必须等待。
 *
 * CountDownLatch是计数器，线程完成一个记录一个，只不过计数不是递增而是递减，而CyclicBarrier更像是一个阀门，需要所有线程都到达，阀门才能打开，然后继续执行。
 *
 * CyclicBarrier和CountDownLatch的区别
 */