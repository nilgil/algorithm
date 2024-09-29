package recursion;

public class Recursion {

    public static void main(String[] args) {
        asc(10);
        System.out.println();
        desc(10);
        System.out.println();
        System.out.println(noneCacheFibonacci(10));
        System.out.println(noneCacheCallCount); // -> 54
        System.out.println(useCacheFibonacci(10));
        System.out.println(useCacheCallCount); // -> 8
    }

    static void asc(int num) {
        if (num == 0) {
            return;
        }
        asc(num - 1);
        System.out.print(num + " ");
    }

    static void desc(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num + " ");
        desc(num - 1);
    }

    static int noneCacheCallCount = 0;

    static int noneCacheFibonacci(int num) {
        noneCacheCallCount++;
        if (num == 2 || num == 1) {
            return 1;
        }
        return noneCacheFibonacci(num - 1) + noneCacheFibonacci(num - 2);
    }

    static int[] cache = new int[46];
    static int useCacheCallCount = 0;

    static int useCacheFibonacci(int num) {
        useCacheCallCount++;
        if (num == 2 || num == 1) {
            return 1;
        }
        if (cache[num] != 0) {
            return cache[num];
        }
        cache[num] = useCacheFibonacci(num - 1) + useCacheFibonacci(num - 2);
        return cache[num];
    }
}
