class Solution:
    def maxProfit(self, prices: List[int]):
        minimum = 100000000
        profit = 0 ;
        for num in prices: 
            minimum = min(minimum , num)
            profit = max ( profit , num - minimum )
            
        return profit
        
        

        
        
'''

[7,1,5,3,6,4]

'''
