##UML Class Diagram:**

![Alt Text](/images/example.jpg)
The UML class diagram for the key classes in the solution can be found in the uml directory.

##Structure Overview:

- **Controller:** Contains the main logic for handling requests.
- **Service:** Contains business logic for applying discounts and calculating the net payable amount.
- **Model:** Contains the data models used by the application.
- **Repository:** Contains interfaces for accessing data.
- **Exception:** Contains custom exception classes.
- **Util:** Contains utility classes.

##Key Classes:

- **UserController:** Handles incoming requests related to user data and bill processing.
- **UserService:** Provides methods for applying discounts and calculating the net payable amount.
- **User:** Represents user data including user type, tenure, and bill information.
- **Bill:** Represents bill information including total amount and list of items.
- **DiscountService:** Contains methods for applying various types of discounts.
- **DiscountStrategy:** Interface defining methods for applying discounts.
- **EmployeeDiscountStrategy, AffiliateDiscountStrategy, TenureDiscountStrategy, BillDiscountStrategy:** Implementations of DiscountStrategy interface for different types of discounts.

- **GroceryItem:** Represents grocery item information.

##Additional Notes:

- Ensure to provide appropriate input data for testing different scenarios.
- Review the coverage reports to ensure adequate test coverage.
- Follow the README.md for detailed instructions on running the application and generating coverage reports.
