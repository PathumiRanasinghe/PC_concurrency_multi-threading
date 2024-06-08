### Lab Exercise 2

ShinePrinters is a printing shop near the University with multiple computers and printers connected 
over a network. Customers can use any computer to create print jobs. These print jobs are then 
placed in a shared queue, from which the printers can retrieve and process them. Suppose you are 
hired to develop this system.  
Implement a producer-consumer-based solution using Java to handle the print jobs in 
ShinePrinters. The excepted classes are PrintJob, 
Computer, Printer, 
SharedQueue, and Main. Assume that ShinePrinters has 3 computers and 2 printers, and the 
capacity of the shared queue is 5. Identify possible memory consistency errors that could occur in 
this multi-threaded system and ensure that those errors and any possible exceptions are 
appropriately handled in your code. 
Suppose the printers in ShinePrinters can handle only certain types of files. Hence, when creating 
the print job, we should check if the system supports the type of the print job and if not, throw 
the TypeNotSupportedException. Extend the Computer and Print classes to handle 
TypeNotSupportedException. 
ShinePrinters plans to introduce a simple web interface for their customers to send print jobs before 
coming to the shop so that they can efficiently get their jobs done. Using Java, implement the 
ReadAFile method to read a given text file and add the text content to an object of the 
TextFile class.
