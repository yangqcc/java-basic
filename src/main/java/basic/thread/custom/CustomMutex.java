package basic.thread.custom;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-15
 * @modified By yangqc
 */
public class CustomMutex {

  private Sync sync = new Sync();

  class Sync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean isHeldExclusively() {
      return Thread.currentThread() == getExclusiveOwnerThread();
    }

    @Override
    protected boolean tryAcquire(int arg) {
      if (getExclusiveOwnerThread() == null || getExclusiveOwnerThread() == Thread
          .currentThread()) {
        while (true) {
          if (this.compareAndSetState(this.getState(), this.getState() + 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            break;
          }
        }
        return true;
      } else {
        return false;
      }
    }

    @Override
    protected boolean tryRelease(int arg) {
      if (getState() == 0) {
        throw new IllegalMonitorStateException();
      }
      setExclusiveOwnerThread(null);
      setState(0);
      return true;
    }
  }

  public void lock() {
    sync.acquire(1);
  }

  public void unlock() {
    sync.release(1);
  }

  public boolean isLocked() {
    return sync.isHeldExclusively();
  }
}
