package interview.io.files;

import sun.misc.Regexp;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alibin on 3/6/15.
 * Write a program to read file of following data structure:
 * Name: favcolor=blue
 * Find out which color is favorite by most people (print the color and number of people)
 */
public class ReadTextStructure {

	public static void main(String[] args) throws IOException {

		File file;
		if (args.length > 0)
			file = new File(args[0]);
		else
			file = new File("test_structure.txt");

		if (!file.exists()) {
			System.out.format("File \"%s\" does not exist\n", file);
			System.exit(-1);
			return;
//			throw IllegalStateException("File not exists");
		}

		Map<String, Integer> structure = readStructure(file);
		System.out.println("Output: ");
		List<ColorStat> colorStats = new ArrayList<ColorStat>();
		for (String key : structure.keySet()) {
			colorStats.add(new ColorStat(key, structure.get(key)));
		}
		Collections.sort(colorStats);
		for (ColorStat colorStat : colorStats) {
			System.out.format("Color: %s, count: %s\n", colorStat.name, colorStat.count);
		}

		System.exit(0);
	}

	public static class ColorStat implements Comparable {
		String name;
		Integer count;
		public ColorStat(String n, Integer c) {
			name = n;
			count = c;
		}

		@Override
		public int compareTo(Object o) {
			if (o.getClass() != ColorStat.class) {
				throw new IllegalArgumentException();
			}
			return -count.compareTo(((ColorStat)o).count);
		}
	}

	public static final String LINE_REGEXP = "^(.*?): favcolor=(.*)$";
	public static final Pattern PATTERN = Pattern.compile(LINE_REGEXP, Pattern.CASE_INSENSITIVE);

	private static Map<String, Integer> readStructure(File file) throws IOException {

/*
		FileInputStream fis = new FileInputStream(file);

		InputStreamReader isr = new InputStreamReader(fis);

		char[] buf = new char[512];

		StringBuilder sb = new StringBuilder();

		if (isr.ready()) {
            int len;
			while (len = isr.read(buf) >= 0) {
			    sb.append(buf, 0, len);
			}
		}
		isr.close();

		System.out.format("File contents: \n%s", sb);
*/

		List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
		Map<String, Integer> summary = new HashMap<String, Integer>();

		for (String line : lines) {
			Matcher matcher = PATTERN.matcher(line);
			if (matcher.matches()) {
				for (int i = 1; i <= matcher.groupCount(); i++) {
					System.out.format("Group %d: %s\n", i, matcher.group(i));
				}
				if (matcher.groupCount() > 1) {
					String color = matcher.group(2);
					Integer c = summary.get(color);
					if (c == null) {
						c = 1;
					} else {
						c += 1;
					}
					summary.put(color, c);
				}
			}
		}

		return summary;
	}

}
