/**
You are asked to build a function to ensure unique names for log files. If a
filename already exists in the system, an integer number should be added at
the end of the filename to make it unique. The integer starts with 1 and is
incremented by 1 for each new file with an existing name.
Given a list of filenames, write an algorithm to output a list of unique filenames
in the order given.
Input
The input to the function/method consists of two arguments:
num, an integer representing the number of filenames;
filenames, a list of strings representing the filenames;
Output
Return a list of strings representing the filenames in the order assigned
Constraints
1 <= num <= 1044
1<= length of filenames[i] >= 20
0 <=i<num
Note
filenames contains only lowercase English letters in the range ASCII[a-z].
Example
Input:
num = 7
filenames = ["system","access", "access", "system","access", "system",
"access"]
Output:
["system","access","access1", "system1","access2", "system2", "access3"]
བཞག་གང་བ། གཞག་གང་ལ་ orienr ་ 
Explanation:
filenames[0] = "system" is unique. uniqueFilename[0]="system" filenames[1] =
"access" is unique. unique Filename[1]="access"
filenames[2] = filenames[1]. Add 1 at the end the previous unique username
"access", uniqueFilename[2]="access"
filenames[3] = filenames[1]. Add 1 at the end the previous unique username
"system", unique Filename[3]="system1"
filenames[4] = filenames[2]. Increment by 1 the number at the end of the
previous unique username "access1", unique Filenames[4]="access"
filenames[5] = filenames[3]. Increment by 1 the number at the end of the
previous unique username "system1". uniqueFilenames[5]="system2"
filenames[6] = filenames[4]. Increment by 1 the number at the end of the
previous unique username "access2". unique Filenames[5]="access3"
return unique Filenames = ["system","access","access1", "system1","access2",
"system2", "access3"]
Example
Input:
num = 12
filenames = ["ref","ref", "ref", "ref","ref", "ref", "ref", "ref", "ref", "ref", "ref", "ref"]
Output:
["ref","ref1", "ref2", "ref3","ref4", "ref5", "ref6", "ref7", "ref8", "ref9", "ref10",
"ref11"]

*/
public class uniqueFileNames {

}
