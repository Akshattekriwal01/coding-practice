## My HandBook to DP
- Before Writing Code:
    - Optimal Substructure 
    - Storge and Meaining
    - Direction
    - Travel and Solve
- While Writing Code:
    - invalid/exceeded cases
    - case of meeting condition
    - real work
    - min cost vs min jump /max/sum

## Storage and Meaning
For Tabulation  Approach only

## Direction
This is the direction that we solve problem. The direction should be from small subproblem to bigger ones. because we need the value of small subproblem to solve bigger ones. 

Ex1. find path from 0th stair to nth stair
A. Multiple Paths to go from 0th to nth stair but only one path from nth to nth stair. 
So the direction should be n -> 0.

Ex2. Find min cost path in Rat Matrix
A. let's say the orignam matrix is 6x6. and we have to find path from (0,0) to (5,5).
Only one path from (5,5) to (5,5)
Multiple Paths from (0,0) to (5,5)
Solve from (5,5) to (0,0). this is like the direction of problem.

## Travel and Solve





