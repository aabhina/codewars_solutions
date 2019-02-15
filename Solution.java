import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(scramble("scriptjavx", "javascript"));

    }

    public static boolean scramble(String str1, String str2) {
        // your code
        boolean isScramble = true;

        if(str1.length() < str2.length()) {
            isScramble = false;
        }

        Map<Character, Integer> str2Map = new HashMap<>();
        for(char c : str2.toCharArray()) {
            if(str2Map.containsKey(c)) {
                str2Map.put(c, (str2Map.get(c) + 1));
            }
            else {
                str2Map.put(c,1);
            }
        }

        for(char c : str1.toCharArray()) {
            if(str2Map.containsKey(c)) {
                str2Map.put(c, (str2Map.get(c) -1));
            }
        }

        for(Character c : str2Map.keySet()) {
            if(str2Map.get(c) > 0) {
                isScramble = false;
            }
        }

        return isScramble;
    }


    public static String listSquared(long m, long n) {
        // your code
        List<Long[]>  finalList = new ArrayList<>();


        for(long i = m; i <= n; i++) {
            List<Long> divisorsList = findAllDivisorsFor(i);
            long sumOfSqauresOfDivisors = 0;

            for(long a : divisorsList) {
                sumOfSqauresOfDivisors += (a*a);
            }

            if(Math.floor(Math.sqrt((double)sumOfSqauresOfDivisors)) == Math.sqrt((double)sumOfSqauresOfDivisors)) {
                //it means it is a perfect sqaure
                //so add it to the final results array
                Long[] tempArr =  new Long[2];
                tempArr[0] = i;
                tempArr[1] = sumOfSqauresOfDivisors;
                finalList.add(tempArr);
            }
        }


        List<String> finList = new ArrayList<>();
        for(Long[] l : finalList) {
            //System.out.println(Arrays.toString(l));
            finList.add(Arrays.toString(l));
        }

        //System.out.println(finList);

        //System.out.println(finalList);
        //Arrays.toString(finalList);

        return finList.toString();
    }

    static List<Long> findAllDivisorsFor(long i) {
        List<Long> divisorsList = new ArrayList<>();

        //Integer[] ar = {1, 2, 3, 6, 7, 14, 21, 42};
        //List<Integer> ls = Arrays.asList(ar);

        for(long num = 1; num <= i; num++) {
            if(i % num == 0) {
                divisorsList.add(num);
            }
        }

        //divisorsList.addAll(ls);

        return divisorsList;

    }


    public static boolean isValid(char[] walk) {
        if(walk.length != 10) {
            return false;
        }

        Map<Character,Integer> mp = new HashMap<>();

        for(char c : walk) {
            if(mp.containsKey(c)) {
                mp.put(c, mp.get(c) +1);
            }
            else {
                mp.put(c,1);
            }
        }

        boolean northSouth = false;
        if(mp.get('n') == mp.get('s')) {
            northSouth = true;
        }

        boolean eastWest = false;
        if(mp.get('e') == mp.get('w')) {
            eastWest = true;
        }

        return northSouth && eastWest;
    }

    static String encode(String word){
        Map<Character, Integer> mp = new HashMap<>();

        for(Character c : word.toLowerCase().toCharArray()) {
            if(mp.containsKey(c)) {
                int temp = mp.get(c);
                mp.put(c,temp + 1);
            }
            else {
                mp.put(c,1);
            }
        }

        StringBuffer sb = new StringBuffer();

        for(Character c1 : word.toLowerCase().toCharArray()) {
            if(mp.get(c1) == 1) {
                sb.append("(");
            }
            else {
                sb.append(")");
            }
        }

        return sb.toString().trim();
    }


    public static String spinWords(String sentence) {
        //TODO: Code stuff here
        StringBuilder sb = new StringBuilder();

        String[] strArr = sentence.split(" ");

        for(String s : strArr) {
            if(s.length() >= 5) {
                StringBuilder temp = new StringBuilder(s);
                temp.reverse();
                s = temp.toString();
            }
            sb.append(s + " ");
        }

        return sb.toString().trim();
    }


    static int find(int[] integers) {
        int outlier = 0;

        //We can find whether the outlier is even or odd
        //by just looking at the 1st 3 elements.
        //Then we can loop through the entire array and find the corresponding outlier

        boolean isEvenArray = true;

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < 3; i++) {
            if ((integers[i] % 2) != 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        if (evenCount < oddCount) {
            isEvenArray = false;
        }

        if (isEvenArray) {
            for (Integer a : integers) {
                if (a % 2 != 0) {
                    outlier = a;
                    break;
                }
            }
        } else if (!isEvenArray) {
            for (Integer b : integers)
                if (b % 2 == 0) {
                    outlier = b;
                    break;
                }
        }

        return outlier;

    }


    static int getSecondMaxNumber(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > first) {
                second = first;
                first = arr[i];
            }
            else if(arr[i] > second) {
                second = arr[i];
            }
        }

        return second;
    }
}
