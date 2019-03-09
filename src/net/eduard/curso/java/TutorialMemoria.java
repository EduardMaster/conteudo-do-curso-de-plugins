package net.eduard.curso.java;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class TutorialMemoria {
	public static ArrayList<String> dados = new ArrayList<>();
	public static int contagematual = 0;
//	private static final long MEGABYTE_FACTOR = 1024L * 1024L;
	private static final DecimalFormat ROUNDED_DOUBLE_DECIMALFORMAT;
	private static final String MIB = "MiB";

	static {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		ROUNDED_DOUBLE_DECIMALFORMAT = new DecimalFormat("####0.00", otherSymbols);
		ROUNDED_DOUBLE_DECIMALFORMAT.setGroupingUsed(false);
	}

	public static String getTotalMemoryInMiB() {
		double totalMiB = bytesToMiB(getTotalMemory());
		return String.format("%s %s", ROUNDED_DOUBLE_DECIMALFORMAT.format(totalMiB), MIB);
	}

	public static String getFreeMemoryInMiB() {
		double freeMiB = bytesToMiB(getFreeMemory());
		return String.format("%s %s", ROUNDED_DOUBLE_DECIMALFORMAT.format(freeMiB), MIB);
	}

	public static String getUsedMemoryInMiB() {
		double usedMiB = bytesToMiB(getUsedMemory());
		return String.format("%s %s", ROUNDED_DOUBLE_DECIMALFORMAT.format(usedMiB), MIB);
	}

	public static String getMaxMemoryInMiB() {
		double maxMiB = bytesToMiB(getMaxMemory());
		return String.format("%s %s", ROUNDED_DOUBLE_DECIMALFORMAT.format(maxMiB), MIB);
	}
	public static double bytesToMiB(long bitus) {
		return bitus/1024;
	}

	public static double getPercentageUsed() {
		return ((double) getUsedMemory() / getMaxMemory()) * 100;
	}

	public static String getPercentageUsedFormatted() {
		double usedPercentage = getPercentageUsed();
		return ROUNDED_DOUBLE_DECIMALFORMAT.format(usedPercentage) + "%";
	}

	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	public static long getUsedMemory() {
		return getMaxMemory() - getFreeMemory();
	}

	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	private static ArrayList<String> listinha = new ArrayList<>();

	public static void main3(String[] args) {

		DecimalFormat df = new DecimalFormat("#,###");
		while (true) {
			System.out.println("------");
			System.out.println("freeMemory KB: " + df.format(Runtime.getRuntime().freeMemory() / 1024));
			System.out.println("maxMemory KB: " + df.format(Runtime.getRuntime().maxMemory() / 1024));
			System.out.println("totalMemory KB: " + df.format(Runtime.getRuntime().totalMemory() / 1024));
			System.out.println("usedMemory KB: " + df.format(getUsedMemory() / 1024));

			for (int i = 0; i < 100000; i++) {
				listinha.add("novo numero: " + i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		DecimalFormat dec = new DecimalFormat("#,###.0");
		Runtime r = Runtime.getRuntime();
		while (true) {

			long freeMemory = r.freeMemory();
			long totalMemory = r.totalMemory();
			long maxMemory = r.maxMemory();

			for (int i = 0; i < 1_000_000; i++) {
				dados.add(" numero " + contagematual);
				contagematual++;
			}
			System.out.println("Free " + dec.format(freeMemory));
			System.out.println("Total " + dec.format(totalMemory));
			System.out.println("Max " + dec.format(maxMemory));
			try {

				System.out.println(" ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
