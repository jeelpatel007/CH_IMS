## CH_IMS

* This is an assignment for basic implementation of an Inventory Management System.
* Methods have been **_synchronized_** and _hashtable_ data-structure is used to ensure 'thread-safety'.

##### Main parts of this system:

1. First the product needs to be added in the inventory stock
2. Once the product(s) have been added, it can been _viewed_ or _picked_ by multiple threads
3. Product re-stocking can be done at any time in the inventory cycle

##### Reference

While solving assignment, [this](http://stackoverflow.com/questions/35190172/how-to-think-of-thread-safe-code-in-below-case-im-new-to-this-and-need-suggest "Jeel's Question on StackOverflow") was used to follow the _synchronized_ style of implementation, as opposed to using standard concurrenct lock and release approach (which was my first instinct).
