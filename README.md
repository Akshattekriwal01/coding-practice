# coding-practice
This repository tracks LeetCode/HackerRank/Codeforces

LC - leetcode

PC - Pepcoding

Question | Pattern | Type | Further Suggestion |time 1 |time 2| Notes | Link 
|--- | --- | --- | --- |--- |--- | --- | --- |
|LC-526-Beautiful_Arrangement | Incrementally build and add element if condition satisfied | Backtracking | Attempt it without using ArrayList | 50 mins |  
|[LC-341-Flatten_Nested_List_Iterator](recursion/LC-341-Flatten_Nested_List_Iterator)| Use 2 Stacks | Recursion | Attempth with 2 stacks only | 15 mins
|[LC-86-Partition_List](Linked_List/LC-86-Partition_List.java)  | 2 pointer | Linked List| follow up without auxillary DS in O(1) mem | 17 mins |
|[LC-1029-Remove_All_Adjecent_Duplicates_in_String_2](String/LC-1029-Remove_All_Adjecent_Duplicates_in_String_2.java)|Notice how the historr of repitition is needed|stack||25 min|
|[PC-Print_Stair_paths](recursion/PC-Print_Stair_paths.java)| Exhaustive Search | Recursion |  | 10 mins | || [Question](https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-stair-paths-official/ojquestion)
|[PC-Matrix_Path](recursion/PC-Matrix_Path.java])| draw the tree and think of base case |Recursion| |15 min| | levels/nodes equivalent to param and edges equiv to the for loop|
|[PC-Matrix_Path_with_Jump](recursion/PC-Matrix_Path_with_Jump.java)| draw the tree and think of options and base case |Recursion| |15 min|| NO Obstacles on Path.
|[PC-Kinghts_Tour](Backtracking/PC-Kinghts_tour.java) | For Every move, you have 8 options. move to a valid option untill board is full then backtrack|BackTracking| |40 mins|||
|[LC-377_Combination_sum_4](Bactracking/LC-377_Combination_sum_4.java)| recur + dp[] | Backtracking|What if input has negative nums?| 10 mins | |Never initialize dp[] or memo[] with 0, because actual ans can be 0|s