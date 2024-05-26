package arrays_strings;

public class NeedleHaystack {
    public static void main(String[] args) {
        String needle = "sad", haystack = "butsad";
        System.out.println(
                "Needle in haystack index(Brute Force) : " + NeedleHaystack.needleHaystackBruteForce(needle, haystack));
    }

    public static int needleHaystackBruteForce(String needle, String haystack) {
        if (needle.length() > haystack.length())
            return -1;
        if (needle.isEmpty())
            return 0;
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
