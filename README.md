# CodingProblem
Encryption
Solution description

The basic idea is to extract the words in s, then calculate the sqrt of the length (truncate the decimal part only remains the integer part) to decide the dimension to store the string. Put the string into such a dimension area, then read by columns and output the final encrypt result.

Time complexity is O(n), n represents the length of string s. Space complexity is O(n).
