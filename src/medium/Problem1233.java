package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1233 {

	// 1st try - faster
	public static List<String> removeSubfolders(String[] folder) {
		List<String> result = new ArrayList<>();
		if (folder == null || folder.length == 0)
			return result;

		if (folder.length > 1)
			Arrays.sort(folder);

		result.add(folder[0]);
		int parentIndex = 0;
		int i = 1;
		String parent = "/";
		while (i < folder.length) {
			parent = folder[parentIndex] + "/";
			if (!folder[i].startsWith(parent)) {
				result.add(folder[i]);
				parentIndex = i;
			}
			i++;
		}
		return result;
	}

	// 2nd try
	public static List<String> removeSubfolders1(String[] folder) {
		// In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
		// After sorting the folder array, we only need to consider if the current
		// folder is a subfolder of the previous one or not.
		Arrays.sort(folder);

		List<String> result = new ArrayList<>();

		for (String dir : folder)
			if (result.isEmpty() || !dir.startsWith(result.get(result.size() - 1) + "/"))
				result.add(dir);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(removeSubfolders(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" }));
		System.out.println(removeSubfolders(new String[] { "/a", "/a/b/c", "/a/b/d" }));
		System.out.println(removeSubfolders(new String[] { "/a/b/c", "/a/b/ca", "/a/b/d" }));
		System.out.println(removeSubfolders(new String[] { "/ah/al/am", "/ah/al" }));
//		System.out.println(removeSubfolders(new String[] { }));
	}

}
