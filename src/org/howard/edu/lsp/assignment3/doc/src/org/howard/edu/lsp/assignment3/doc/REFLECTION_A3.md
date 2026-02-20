# Assignment 3 Reflection

## Design Differences

In Assignment 2, all ETL logic was in a single class, making it functional 
but difficult to maintain or extend. In Assignment 3, responsibilities 
were separated into distinct classes: Product, ProductReader, 
ProductTransformer, ProductWriter, and ETLApplication. This modular 
approach improves readability, maintainability, and scalability.

## How Assignment 3 Is More Object-Oriented

Assignment 3 introduces true object-oriented design:

- **Product class** encapsulates product data.
- **Encapsulation** is applied via private fields and public 
getters/setters.
- **Separation of concerns** ensures each class has a single 
responsibility.
- **Polymorphism and inheritance** were considered; while not strictly 
needed, the structure allows for easy extension.

## Testing

To confirm Assignment 3 behaves like Assignment 2:

- Compared `transformed_products.csv` from both versions.
- Verified header, row count, rounding, and price range classifications 
match.
- Tested edge cases: missing input file and empty input file.

## Use of AI Assistant

A generative AI was used to brainstorm class structure, generate Javadocs, 
and refine modular design. AI suggestions were carefully reviewed, 
modified for correctness, and tested to ensure identical Assignment 2 
behavior.

## Lessons Learned

- Modular design improves readability and maintainability.
- AI can accelerate coding but requires validation.
- Object-oriented principles make future extensions easier.
