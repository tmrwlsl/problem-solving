class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int[] check = new int[A.length + 1];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += getCount(A, i, check) + getCount(B, i, check);
            ans[i] += count;
        }
        return ans;
    }

    private int getCount(int[] arr, int idx, int[] check) {
        check[arr[idx]]++;
        if(check[arr[idx]] == 2){
            return 1;
        }
        return 0;
    }

}
