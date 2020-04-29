# CodingProblem
Encryption
Solution description (https://github.com/mountainowl/snapcheck-internship-2020/tree/master/backend)

The basic idea is to count the letters in s, then calculate the sqrt of the length (truncate the decimal part only remain the integer part) to decide how many columns to store the string. Each column is a bucket to store the corresponding column letters. Finally we just join the string in each bucket together to get the final string.

Time complexity is O(n), n represents the length of string s. Space complexity is O(n).
