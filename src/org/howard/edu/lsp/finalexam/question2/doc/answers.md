Template Method is used in the Report class through the generateReport() 
method, which defines a fixed workflow. Subclasses override loadData(), 
formatHeader(), formatBody(), and formatFooter() to customize behavior. 
This allows code reuse while maintaining flexibility. Polymorphism is 
shown when different report types are processed through the same 
interface.
