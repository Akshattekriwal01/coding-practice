class Solution:
    def countBinarySubstrings(self, s: str) -> int: 
        ans = 0 #accumulates the balanced substring we have found sofar
        curr = None #the curr digit we have seen of the count_curr
        count_prev = 0 #the size of the group before the current group
        count_curr = 0 #the size of the group we are still accumulating now
        
        for digit in s:
            if digit == curr:
                count_curr+=1
                if count_curr <=count_prev: #note we can only add to the final count of the balanced substring, if the curr group does not exceed in size of the previous group
                    ans+=1
            else: # we are switching digit
                ans+=1
                curr = digit
                count_prev = count_curr
                count_curr = 1
        
        return ans-1