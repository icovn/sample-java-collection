package net.friend.util;

import java.lang.instrument.Instrumentation;

public class StorageUtil {

  private static final long KILOBYTE = 1024L;
  private static final long MEGABYTE = 1024L * 1024L;

  private static Instrumentation instrumentation;

  public static void premain(String args, Instrumentation inst) {
    instrumentation = inst;
  }

  public static long getObjectSize(Object o) {
    return instrumentation.getObjectSize(o);
  }

  public static long bytesToKilobytes(long bytes) {
    return bytes / KILOBYTE;
  }

  public static long bytesToMegabytes(long bytes) {
    return bytes / MEGABYTE;
  }
}
