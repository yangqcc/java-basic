package basic.atomic;

/**
 * AtomicInteger 类小狐妖利用CAS (compare and swap)+volatile和native
 * 方法来保证原子操作，从而避免synchronized的高开小，执行效率大为提升
 *
 * CAS原理是拿期望的值和原本的一个值作比较，如果相同则更新新的值。UnSafe类的objectFieldOffset()方法是一个本地方法，
 * 这个方法是用来拿到"原来的值"的内存地址。另外value是一个volatile变量，在内存中可见，因此JVM可以保证任何时刻线程总能
 * 拿到该变量的最新值
 */