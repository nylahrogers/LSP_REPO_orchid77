The OrderProcessor class has poor object-oriented design. It violates 
encapsulation because its fields are public. It also violates the single 
responsibility principle because it handles multiple tasks such as 
calculating totals, printing receipts, saving to a file, sending emails, 
and logging. This makes the code difficult to maintain, test, and extend.
