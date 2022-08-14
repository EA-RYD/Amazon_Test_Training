# Description
- Basically layer based traversal
- The only catch here is, that, unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex. BFS uses a queue data structure for traversal.
- 



# Best Fit For
- Problems that make progress in waves (IE rotten orange infecting other oranges in minute increments)