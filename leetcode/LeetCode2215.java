class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return List.of(
            nums1Set.stream().filter(num -> !nums2Set.contains(num)).toList(),
            nums2Set.stream().filter(num -> !nums1Set.contains(num)).toList()    
        );
    }
}
