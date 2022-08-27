package Search_Suggestions_System;
import java.util.*;

public class MySolnSSS {
    /*
     * 
     You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products 
after each character of searchWord is typed. Suggested products should 
have common prefix with searchWord. If there are more than three products 
with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of 
searchWord is typed.
     */
    public static void main(String[] args) {
        
    }

    //binary search
    /*
     Since the question asks for the result in a sorted order, 
     let's start with sorting products. An advantage that comes with 
     sorting is Binary Search, we can binary search for the prefix. 
     Once we locate the first match of prefix, all we need to do is 
     to add the next 3 words into the result (if there are any), 
     since we sorted the words beforehand.


    1.Sort the input products.
    2.Iterate each character of the searchWord adding it to the prefix to search for.
    3.After adding the current character to the prefix binary search for the 
    prefix in the input.
    4. Add next 3 strings from the current binary search start index till the
     prefix remains same.
    5. Another optimization that can be done is reducing the binary 
    search space to current start index (This is due to the fact that 
    adding more characters to the prefix will make the next search 
    result's index be at least > current search's index).

     */
    // Equivalent code for lower_bound in Java
    public int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;

            // Get the starting index of word starting with `prefix`.
            start = lower_bound(products, bsStart, prefix);

            // Add empty vector to result.
            result.add(new ArrayList<>());

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }
        return result;
    }


    //approach 2: Trie + DFS
    /*
     Whenever we come across questions with multiple strings, 
     it is best to think if Trie can help us. What we need here is a 
     way to search for all the words with given prefix, this is a well 
     known problem that trie can solve. The question also asks for a sorted
      results, if you look closely a trie word is represented by it's preorder
       traversal. It is also worth noting that a preorder traversal of a
        trie will always result in a sorted traversal of results, thus all we 
        need to do is limit the word traversal to 3.



    1. Create a Trie from the given products input.
    2. Iterate each character of the searchWord adding it to the prefix to 
    search for.
    3. After adding the current character to the prefix traverse the trie 
    pointer to the node representing prefix.
    4. Now traverse the tree from curr pointer in a preorder fashion and 
    record whenever we encounter a complete word.
    5. Limit the result to 3 and return dfs once reached this limit.
    6. Add the words to the final result.

     */

     // Custom class Trie with function to get 3 words starting with given prefix
class Trie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    Node Root, curr;
    List<String> resultBuffer;

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children.get(c - 'a') != null)
                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
    }
    Trie() {
        Root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {

        // Points curr to the root of trie.
        curr = Root;
        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                curr.children.set(c - 'a', new Node());
            curr = curr.children.get(c - 'a');
        }

        // Mark this node as a completed word.
        curr.isWord = true;
    }
    List<String> getWordsStartingWith(String prefix) {
        curr = Root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultBuffer;
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
};
class Solution {
    List<List<String>> suggestedProducts(String[] products,
                                         String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
};
}
