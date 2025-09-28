package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements AutoCloseable {
    private final FileWriter writer;

    public CSVWriter(String filename) throws IOException {
        writer = new FileWriter(filename);
        writer.write("n,algo,time_ms,comparisons,allocations,depth\n");
    }

    public void writeRow(int n, String algo, long timeMs,
                         long comparisons, long allocations, int depth) throws IOException {
        writer.write(String.format("%d,%s,%d,%d,%d,%d\n",
                n, algo, timeMs, comparisons, allocations, depth));
    }

    @Override
    public void close() throws IOException {
        writer.flush();
        writer.close();
    }
}

