class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int index1 = 0;
        int index2 = numbers.length-1;
        for (int i = 0; i < numbers.length;i++){
            if(numbers[index1] + numbers[index2] == target){
                result[0] = index1+1;
                result[1] = index2+1;
            }
            else if(numbers[index1] + numbers[index2] > target){
                index2 = index2 - 1;   
            }
            else{
                index1 = index1 + 1;
            }
        }
        return result;
    }
}
