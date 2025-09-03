# Coding-Exercise-USFWS

- Does the solution work for larger graphs?

Yes. Since it uses memoization, it avoids recalculating paths from vertices that have already been processed.



- Can you think of any optimizations?

One optimization I focused on was memoization. I stored the longest path from each vertex to avoid recalculation.

If I were to improve this further, I'd look into using a Set instead of an ArrayList for storing neighboring vertices. 
Sets automatically prevent duplicates and can be faster when checking if something is already there. Since order doesn't
matter in this case, it adds to why a Set may be an optimization.




- What’s the computational complexity of your solution?

The time it takes to run this code grows in proportion to the number of vertices and edges in the graphs we create.
It goes through every edge onces to create the graph and visits each vertex once when finding the longest path since
it stores results it's already calculated.



- Are there any unusual cases that aren't handled?

I haven't tried handling cases where the input list is empty or where the starting vertex isn't actually in the graph
which might cause unexpected outputs. I also haven't accounted for scenarios where someone might pass a path that loops
as opposed to a DAG. This could cause the recursion to go infinitely.
