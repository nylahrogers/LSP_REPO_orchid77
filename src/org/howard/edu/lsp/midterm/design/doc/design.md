Class: Order
Responsibilities: store order data
Collaborators: none

Class: TaxCalculator
Responsibilities: calculate tax
Collaborators: Order

Class: ReceiptPrinter
Responsibilities: print receipt
Collaborators: Order

Class: EmailService
Responsibilities: send confirmation email
Collaborators: Order

Class: FileStorage
Responsibilities: save order to file
Collaborators: Order
