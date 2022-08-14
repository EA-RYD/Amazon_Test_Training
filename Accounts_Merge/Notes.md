# Explain
  1.  The key task here is to connect those emails, and this is a perfect use case for union find.
  2.  to group these emails, each group need to have a representative, or parent.
  3.  At the beginning, set each email as its own representative.
  4.  Emails in each account naturally belong to a same group, and should be joined by assigning to the same parent (let's use the parent of first email in that list);


  Basicly, this is a graph problem. Notice that each account[ i ] tells us some edges. What we have to do is as follows:

Use these edges to build some components. Common email addresses are like the intersections that connect each single component for each account.
Because each component represents a merged account, do DFS search for each components and add into a list. Before add the name into this list, sort the emails. Then add name string into it.

Examples: Assume we have three accounts, we connect them like this in order to use DFS.
{Name, 1, 2, 3} => Name -- 1 -- 2 -- 3
{Name, 2, 4, 5} => Name -- 2 -- 4 -- 5 (The same graph node 2 appears)
{Name, 6, 7, 8} => Name -- 6 -- 7 -- 8
(Where numbers represent email addresses).

# Example
a b c // now b, c have parent a
d e f // now e, f have parent d
g a d // now abc, def all merged to group g

parents populated after parsing 1st account: a b c
a->a
b->a
c->a

parents populated after parsing 2nd account: d e f
d->d
e->d
f->d

parents populated after parsing 3rd account: g a d
g->g
a->g
d->g
 

