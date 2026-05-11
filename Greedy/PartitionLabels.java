/*

Problem:

You are given a string s. Partition s into as many parts as possible so that each letter appears in at most one part. Return the lengths of these parts.

Example:

Input:  s = "ababcbacadefegdehijhklij"
Output: [9, 7, 8]
Explanation:
  "ababcbaca" | "defegde" | "hijhklij"
   length 9     length 7    length 8
Verify: 'a' only in part 1, 'b' only in part 1, 'c' only in part 1,
        'd' only in part 2, 'e' only in part 2, ...
Why greedy?

Each letter has a last occurrence in the string.
Once you commit to a partition starting at index i, the partition must extend at least to the last occurrence of every letter inside it — otherwise you'd split a letter across partitions.
So as you scan from left to right, you grow the partition's required end whenever you encounter a letter whose last occurrence is further than your current end.
When you hit your current end, you've safely closed a partition.

*/



// Trigger: "Decisions depend on something that happens later in the input." Insight: Precompute last-occurrence (or next-occurrence) in O(n), then scan greedily.


class Solution {
    public List<Integer> partitionLabels(String s) {
        // create map
        // store latest indexing by constantly updating the index for each char
        
        HashMap<Character, Integer> map=new HashMap<>();


        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);       
        }

       List<Integer> result=new ArrayList<>();
       int start=0, end=0;

       for(int i=0;i<s.length();i++){
            end=Math.max(end, map.get(s.charAt(i)));
            if(i==end){
                result.add(end-start+1);
                start=i+1;
            }
       }

        return result;
       
    }
}




/*
LC 2405 — Optimal Partition of String (similar — partition by distinct chars)

public int partitionString(String s) {
    boolean[] seen = new boolean[26];
    int parts = 1;
    for (char c : s.toCharArray()) {
        if (seen[c - 'a']) { parts++; Arrays.fill(seen, false); }
        seen[c - 'a'] = true;
    }
    return parts;
}

*/

