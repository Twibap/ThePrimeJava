package io.github.twibap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class PrimeWriter extends Thread {

    private final Queue<Integer> queue;
    private boolean countingDone = false;
    private final String fileName;

    public PrimeWriter(Queue<Integer> queue, int value) {
        super("Prime Writer");
        this.queue = queue;
        fileName = "PrimeNumbersUnder"+value+".txt";
    }

    @Override
    public void run() {
        File file = new File("./out/"+fileName);
        FileWriter writer;
        try {
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            
            writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            while (!countingDone || !queue.isEmpty()) {
                if (file.length() != 0)
                    bufferedWriter.newLine();
                if (!queue.isEmpty()) {
                    String strNumber = String.valueOf(queue.poll());
                    bufferedWriter.write(strNumber);
                    bufferedWriter.flush();
                }
            }

            System.out.println("Prime numbers are written!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void done() {
        countingDone = true;
    }
}
