class Solution {
    static boolean computed = false;
    static List<Integer> v = new ArrayList<>();

    public void compute() {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j <= 1000; j++) {
                int sum = i * i * i + j * j * j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                v.add(entry.getKey());
            }
        }

        computed = true;
    }

    public List<Integer> findGoodIntegers(int n) {
        if (!computed) compute();

        List<Integer> ans = new ArrayList<>();
        for (int num : v) {
            if (num <= n) ans.add(num);
            else break;
        }

        return ans;
    }
}