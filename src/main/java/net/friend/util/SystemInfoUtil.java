package net.friend.util;

import java.io.File;
import java.text.NumberFormat;

public class SystemInfoUtil {

  private static Runtime runtime = Runtime.getRuntime();

  public static String getInfo() {
    StringBuilder sb = new StringBuilder();
    sb.append(getOsInfo());
    sb.append(getMemInfo());
    sb.append(getDiskInfo());
    return sb.toString();
  }

  public static String getMemInfo() {
    NumberFormat format = NumberFormat.getInstance();
    StringBuilder sb = new StringBuilder();
    long maxMemory = runtime.maxMemory();
    long allocatedMemory = runtime.totalMemory();
    long freeMemory = runtime.freeMemory();
    sb.append("Free memory: ");
    sb.append(format.format(freeMemory / 1024));
    sb.append("\r\n");
    sb.append("Allocated memory: ");
    sb.append(format.format(allocatedMemory / 1024));
    sb.append("\r\n");
    sb.append("Max memory: ");
    sb.append(format.format(maxMemory / 1024));
    sb.append("\r\n");
    sb.append("Total free memory: ");
    sb.append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
    sb.append("\r\n");
    return sb.toString();

  }

  public static String getOsInfo() {
    StringBuilder sb = new StringBuilder();
    sb.append("OS: ");
    sb.append(getOSname());
    sb.append("\r\n");
    sb.append("Version: ");
    sb.append(getOSversion());
    sb.append("\r\n");
    sb.append(": ");
    sb.append(getOsArch());
    sb.append("\r\n");
    sb.append("Available processors (cores): ");
    sb.append(runtime.availableProcessors());
    sb.append("\r\n");
    return sb.toString();
  }

  public static String getDiskInfo() {
    /* Get a list of all filesystem roots on this system */
    File[] roots = File.listRoots();
    StringBuilder sb = new StringBuilder();

    /* For each filesystem root, print some info */
    for (File root : roots) {
      sb.append("File system root: ");
      sb.append(root.getAbsolutePath());
      sb.append("\r\n");
      sb.append("Total space (bytes): ");
      sb.append(root.getTotalSpace());
      sb.append("\r\n");
      sb.append("Free space (bytes): ");
      sb.append(root.getFreeSpace());
      sb.append("\r\n");
      sb.append("Usable space (bytes): ");
      sb.append(root.getUsableSpace());
      sb.append("\r\n");
    }
    return sb.toString();
  }

  public static String getOSname() {
    return System.getProperty("os.name");
  }

  public static String getOSversion() {
    return System.getProperty("os.version");
  }

  public static String getOsArch() {
    return System.getProperty("os.arch");
  }

  public static long getTotalMem() {
    return Runtime.getRuntime().totalMemory();
  }

  public static long getUsedMem() {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
  }


}
