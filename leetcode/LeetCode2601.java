class Solution {
    boolean[] primes = new boolean[1001];

    void sieve(){
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i * i <= 1000; i++){
            if(!primes[i]){
                continue;
            }
            for(int j=i*i; j <= 1000; j+=i){
                primes[j] = false;
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        sieve();
        int pre = 0;
        for(int i=0; i<nums.length; i++){
            for(int j = nums[i] - 1; j>=2; j--){
                if(!primes[j]){
                    continue;
                }
                if(nums[i] - j > pre){
                    nums[i] -= j;
                    break;
                }
            }
            pre = nums[i];
        }
        for(int i=0; i<nums.length - 1; i++){
            if(nums[i] >= nums[i + 1]){
                return false;
            }
        }
        return true;
    }
}
