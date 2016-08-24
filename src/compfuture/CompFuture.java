package compfuture;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompFuture {

    public static void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ioe) {
            // do nothing
        }
    }

    public static CompletableFuture<String> getFileContents(Path p) {
        System.out.println("getFileContents running in " + Thread.currentThread().getName());
        CompletableFuture<String> rv = new CompletableFuture<>();
        try {
            AsynchronousFileChannel afc = AsynchronousFileChannel.open(p, StandardOpenOption.READ);
            long size = afc.size();
            if (size > Integer.MAX_VALUE) {
                throw new IOException("File too large");
            }
            ByteBuffer bb = ByteBuffer.allocate((int) (size));
            afc.read(bb, 0, rv, new CompletionHandler<Integer, CompletableFuture<String>>() {
                @Override
                public void completed(Integer result, CompletableFuture<String> cf) {
                    bb.flip();
                    CharBuffer cb = Charset.defaultCharset().decode(bb);
                    String rv = cb.toString();
                    System.out.println("Handler: completed producing " + rv
                            + " in thread " + Thread.currentThread().getName());
                    cf.complete(rv);
                }

                @Override
                public void failed(Throwable exc, CompletableFuture<String> cf) {
                    System.out.println("Handler: failed, throwing " + exc.getMessage()
                            + " in thread " + Thread.currentThread().getName());
                    cf.completeExceptionally(exc);
                }
            });
        } catch (IOException e) {
            rv.completeExceptionally(e);
        }

        return rv;
    }

    public static String delayText(String s) {
        System.out.println("delayText in thread " + Thread.currentThread().getName());
        delay(1000);
        return "Delayed: " + s;
    }

//    public static CompletableFuture<String> retry(Throwable t) {
//        System.out.println("retry in thread " + Thread.currentThread().getName());
//        return getFileContents(Paths.get("test.txt"));
//    }
    public static void main(String[] args) {

        try {
            System.out.println("Result is "
                    + CompletableFuture.supplyAsync(() -> Paths.get("test1.txt"))
                    .thenCompose(CompFuture::getFileContents)
                    .handle((s, t) -> {
                        if (s != null) {
                            return CompletableFuture.completedFuture(s);
                        }
                        return CompletableFuture.supplyAsync(() -> Paths.get("test.txt")).thenCompose(CompFuture::getFileContents);
                    })
                    .thenApply(cf -> {
                        String rv = "Buggered, neither file worked!";
                        try {
                            rv = cf.get();
                        } catch (InterruptedException | ExecutionException ex) {
                        }
                        return rv;
                    })
                    .thenApply(CompFuture::delayText)
                    .get());
        } catch (InterruptedException ex) {
            System.out.println("Interrupted... " + ex.getMessage());
        } catch (ExecutionException ex) {
            Throwable cause = ex.getCause();
            System.out.println("Execution failed by " + cause.getClass().getName() + " with " + cause.getMessage());
        }
    }
}
