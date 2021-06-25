# ADT- and Java-demonstration

This is a small demonstration of Java-programming and abstract data types (ADT) 
hash set, binary tree and list. `ADTDemo.java` creates many elements (the number of 
elements is set on variable `maxElements`), stores them to ArrayList and HashSet or Tree, depending on the 
user's choice. Then the program clocks `contains`-methods correspondingly. See the 
source code for more details.

## Implementation

User can choose from menu to test either hash set's or binary tree's 
`contains`-method's run time. Regardless user's choice, array list is tested
also for reference. All collections (hash set, array list and binary tree) 
are warmed up before the actual clocking. This is done because the Java 
Virtual Machine seems to optimize some processes while running the program when it 
detects that they are repeated many times. So, with warming up, this program's 
clocking is based on optimized run time.

The program uses Java's own data collections HashSet and ArrayList. 
Binary tree is implemented on classes `TreeDemo` and `NodeDemo`. They implement 
only the functionality that is needed for this demonstration, so the code can not 
be used in general as it is.
