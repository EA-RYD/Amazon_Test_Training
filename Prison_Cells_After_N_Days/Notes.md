# Prompt:
There are 8 prison cells in a row and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.

Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.

Return the state of the prison after n days (i.e., n such changes described above).

# Topics:
- Pigeonhole principle: In mathematics, the pigeonhole principle states that if n items are put into m containers, with n > m, then at least one container must contain more than one item.For example, if one has three gloves (and none is ambidextrous/reversible), then there must be at least two right-handed gloves, or at least two left-handed gloves, because there are three objects, but only two categories of handedness to put them into. 
- There are only 2^cells[length] (512) possibilities and to avoid having to recalculate we store into array and keep checking if exists already in array
- There are only so many combinations so we know eventually we will reach a cycle and the point we reach that cycle depends on initial input
- Once we see a repeat of an array then we know we have a full cycle
    - At this point we can just get N % cycle_length to find the desired result



