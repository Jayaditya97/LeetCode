class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0;
        int mx = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        while (j < fruits.length) {
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            if (mp.size() <= 2) {
                mx = Math.max(mx, j - i + 1);
            }
            else {
                while (mp.size() > 2) {
                    mp.put(fruits[i], mp.get(fruits[i]) - 1);

                    if (mp.get(fruits[i]) == 0) {
                        mp.remove(fruits[i]);
                    }

                    i++;
                }
            }

            j++;
        }

        return mx;
    }
}