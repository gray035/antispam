package main.java.com.antispam.ThreadTest;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by yangshenneng on 14/12/19.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base dir :");
        String dir = in.nextLine();
        System.out.print("Enter key words");
        String keyword = in.nextLine();
        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask(queue,new File(dir));
        new Thread(enumerator).start();
        for(int i = 1; i <= SEARCH_THREADS; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }

    private static class FileEnumerationTask implements Runnable{
        public static File DUMMY = new File("");
        private BlockingQueue<File> queue;
        private File startingDir;

        public FileEnumerationTask(BlockingQueue<File> queue,File startingDir) {
            this.queue = queue;
            this.startingDir = startingDir;
        }

        public void run() {
            try {
                enumerate(startingDir);
                queue.put(DUMMY);
            } catch (InterruptedException e) {

            }
        }

        private void enumerate(File dir) throws InterruptedException {
            File[] files = dir.listFiles();
            for(File file : files) {
                if(file.isDirectory())
                    enumerate(file);
                else
                    queue.put(file);
            }
        }
    }

    private static class SearchTask implements Runnable {
        private BlockingQueue<File> queue;
        private String keyword;

        public SearchTask(BlockingQueue<File> queue, String keyword) {
            this.keyword = keyword;
            this.queue = queue;
        }

        public void run() {
            try {
                boolean done = false;
                while(!done) {
                    File file = queue.take();
                    if(file == FileEnumerationTask.DUMMY) {
                        queue.put(file);
                        done = true;
                    } else {
                        search(file);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void search(File file) throws IOException{
            Scanner in = new Scanner(file);
            int lineNumber = 0;
            while(in.hasNextLine()) {
                lineNumber ++;
                String line = in.nextLine();
                if(line.contains(keyword)) {
                    System.out.printf("%s:%d:%s\n",file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
