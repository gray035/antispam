package main.Factory.ch10;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangshenneng on 15/2/26.
 */
public class Entry {
    public static void main(String[] args) {
        //threadTest();
        deadLock();
    }

    //notifyElementAdded 在对set进行遍历的过程中调用了remove方法使得迭代器中断，对象被改变了
    //多进程所带来的问题
    public static void threadTest() {
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23)
                    set.removeObserver(this);
            }
        });

        for(int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    public static void deadLock() {
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(final ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                set.removeObserver(observer);
                            }
                        }).get();
                    } catch (ExecutionException ex) {
                        throw new AssertionError(ex.getCause());
                    } catch (InterruptedException ex) {
                        throw new AssertionError(ex.getCause());
                    } finally {
                        executor.shutdown();
                    }
                }
            }
        });

        for(int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
