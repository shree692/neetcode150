/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    return bs(nums,0,nums.length-1,target);
};
function bs(nums,left,right,target){
    if(left>right) return -1;
    let mid = Math.floor((right+left)/2);
    if(nums[mid] === target) return mid;
    if(nums[mid] < target) return bs(nums,mid+1,right,target);
    return bs(nums,left,mid-1,target);
}