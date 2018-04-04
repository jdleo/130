1. Who is in your group?
-- John Leonardo, W Reed.

2. How long did the project take?
-- I started the project on Sunday (April 1), and finished the project on Tuesday (April 3). If I were to estimate, the entire work-time of this project was ~10 hours.

3. Before you started, which data structure did you expect would be the fastest?
-- Hash Table.

4. Which data structure is the fastest? Why were you right or wrong?
-- Binary Search Trees. I was wrong, because with two documents, the input size will never be  astronomically large. We won't have input sizes of 1m, or 1b. Only with these large sizes do AVL beat BST. Also, with Hash Tables, the quadratic probing was creating a bottleneck in performance, which allowed BST to crush everything.

5. In general, which DataCounter dictionary implementation was "better": trees or hashtables? Note that you will need to define "better" (ease of coding, ease of debugging,memory usage, disk access patterns, runtime for average input, runtime for all input, etc).
-- My definition of "better" is the perfect mixture of a low, code footprint (less code), and not a terrible runtime. The DataCounter implementation that I think is "better" would be the trees.

6. Are there cases in which a particular data structure performs really well or badly in thecorrelator? Enumerate the cases for each data structure.
-- With my implementation of Hash Table, I use quadratic probing with prime table sizes that resize when needed (always prime though). This performs very, very poorly with larger documents (over 60,000 total words). Something to do with how I hash and insert my data.

7. Give a one to two paragraph explanation of whether or not you think Bacon wroteShakespeare's plays based on the data you collected. No fancy statistical analysis here(formal analysis comes later); keep it fun and simple.
-- Based on the data I collected, I don't think Bacon wrote Shakespeare's plays. I brought in 3 more .txt files to test, so that I could see what I could consider a "good", or "bad" correlation score. I brought in Macbeth (also by Shakespeare), The Jew Of Malta (by a playwright in Shakespeare's exact era), and Nancy Brandon (a writer with a completely different style). Here are the results:
Hamlet (Shakespeare) vs The New Atlantis (Bacon): 0.116
Hamlet (Shakespeare) vs Macbeth (Shakespeare): 0.033
Hamlet (Shakespeare) vs Nancy Brandon: 0.135
We know that Shakespeare wrote both Hamlet and Macbeth, so it makes sense that this would have a lower total distance metric. However, Nancy Brandon is nothing close to Shakespeare's writing style, yet it scored closer to the Bacon/Shakespeare comparison. This is my main reason for why I don't believe that Bacon wrote Shakespeare's play.

8. ---------------- BENCHMARKS ----------------
