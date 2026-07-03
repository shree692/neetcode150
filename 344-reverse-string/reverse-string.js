/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    let left = 0;
    let right = s.length-1;
    rev(s,left,right);
    return s;
};
function rev(s,left,right){
    if(left>=right) return;
    [s[left],s[right]] = [s[right],s[left]];
    rev(s,left+1,right-1);
}