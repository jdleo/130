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

>>> What are you measuring?
For WordCount.java program, when using -performance flag, I am measuring how long (ms) it takes to insert all the word data from the document, into the data structure of choice.  
For Correlator.java program, when using -performance flag, first, I measure how long it takes for inserting word data from BOTH documents into data structure of choice. THEM, I also measure how long it takes to calculate the correlation score between the two.

>>> What is the definition of "better" given your measurement?
Assuming that all implementations run correctly, "better" would mean a lower runtime.

>>> Why is the measurement interesting in determining which is the superior algorithm for this project?
A lower runtime is good in most cases. As we scale or input sizes up, we want an algorithm that is going to outperform the others in terms of runtime. This is good practice for the real-world when we have to scale algorithms to support bigger data.

>>> What was your method of benchmarking?
I used System.currentTimeMillis() to get the current UNIX time in milliseconds. I would put one at the beginning of a block of code, and one at the end. Then I would subtract the two, to get runtime of those crucial blocks of code that I wanted to benchmark.

>>> What were the sources of errors?
In terms of benchmarking, there were quite a few errors I had to figure out so that my programs could scale better. This was good practice in being able to identify bottlenecks in my programs, and work them out. The main sources of my errors came from putting operations on the wrong side of loops. For example, there is a lot of code we can do outside of a loop, but we still put it inside, which leads to bottlenecks. Also, I tried to avoid n^2 as much as I could to avoid errors.

>>> What were your results?
-- WordCount --
BST: 39 ms
AVL: 1409 ms
HashTable: 356 ms

-- Correlator: --
BST: 234 ms
AVL: 1947 ms
HashTable: 782 ms

>>> How did you interpret your results?
First, I interpret these results that BinarySearchTree was the fastest data structure algorithm for this use case. Second, I also question whether AVL is as fast is it could be. I tried to optimize, but I guess algorithms can always be faster.

>>> What were your conclusions?
My conclusions are that Binary Search Tree was the best algorithm to implement for this use-case. Not only did it have a relatively low code-footprint, but it also crushed the other two Data Structures in runtime. I know there are ways I could scale AVL and HashTable, but the combination of the ease-of-coding and runtime puts BSTs above the others.

>>> Are there any interesting directions for future study?
This definitely puts us in the right direction for a series of topics. The first one that comes to my head is understand the infrastructure and how a website like TurnItIn.com works, to detect plagiarism. I'm sure they use a similar technology to what we were working with. This also leads me to have an interest in studying about how Google works in ranking their web pages, and how well it correlates to what our search terms are.

9. What did you enjoy about this assignment? What did you hate? Could we have done anything better?
-- I most enjoyed that this assignment had a real-world application. In past Computer Science projects, we are given easy tasks like "make a calendar", or "make a scheduling program". These are helpful to learn OOP, but they don't have many real-world applications. This assignment gave us just that. It gave me a better understanding of how to identify bottlenecks in Java programs, how to scale, and how to choose between algorithms based on efficiency in certain use-cases.

I didn't find myself 'hating' anything, honestly.

In my opinion, you could make the project instructions pdf a little friendlier. Maybe provide some code samples, and some OOP guidance. Personally, this wasn't an issue for me, but I know a lot of my classmates were struggling because they didn't even know where to begin.

