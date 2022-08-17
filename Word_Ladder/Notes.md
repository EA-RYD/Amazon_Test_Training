# Explain
So, all this problem is asking us to do, is find a shortest path from our start word to end word using only word inside our list. Now any time you are looking to find the shortest sequence you should immediately think, alright i need to use some shortest path algorithm like Breadth-First-Search.


# Example
Let's take an example:

start = be
end = ko
words = ["ce", "mo", "ko", "me", "co"]

So, using this word list we have 4 different path's that we can take to get from our start to end word.

    So, we can go from "be" -- "ce" -- "co" -- "ko"

There are other's path as well to go from start word to end word, however we only consider the shortest path, the one that has least amount of word in the sequence and in that case that would be:

So, in a typicall Breadth-First-Search we utilize the queue and it's going to store each string that in our sequence & then we also going to have integer value called changes which will be eventually return from our function, which will keep track how many changes do we have in the sequence.

So, we intialize our queue that have starting word inside of it i.e. "be", then our changes variable is going to start at 1, this is because at minimum we going to have starting word in our minimum. And finally we have a set which will keep track's of node that have been visited, in this case we just keeping track of string that we have already added inside our queue.

So, to start of our bfs, we take "be" off from our queue & we can only change one character at a time. So, first we gonna check by changing the character b, if we can form another word inside our word list.

    So, we try ae, which is not in our word list. Then, be is already in our set, so we can't use that. Now we try ce and we have that word inside our word list. With that means add ce in our queue.

    Then we check de, fe and so on............ until we get to me which is inside our word list, so we add me inside our word list as well.

    So, all that way we check all the way down to ze and there is no other words that we add by changing b to another character.

    So, now we need to check first index. So, by changing the character e from be to something else if we form an another word.

    So, we gonna check ba, bb all the way down to bz. However none of the word inside our word list.
    Adittionaly, thw word ce & me are going to get added inside our set. To show, that we have already visited those words.

    And then we gonna perform same logic as before. We poll from our queue we take ce off from our queue. And we check if by changing any character we can form another word.

    So, we gonna see if we change first character c to another character to form a word. So, we gonna try ae , be, ce which is already in our set doesn't count de, ee all the ay down to ze and none of the word included inside our word

    And that is our end word. Once, we find our end word we poll from our queue and that is equal end word then we know we have found our shortest path sequence, so we just return 4 from this function.
