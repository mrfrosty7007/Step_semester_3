# Week 8 — Advanced OOP Concepts, Quiz & Answers

Course: **B2P15-804 | Classroom 100 Coding Hours Practice**  
Program: **STEP (Student Training in Engineering Program) — Semester 3**  
Institution: **SRM Institute of Science and Technology**  
Topic: **Inheritance, Runtime Polymorphism, Abstraction & Interfaces**

---

## Part 1: Quiz Questions & Answers

### Question 1
**Scenario:** A system processes Document objects. It initially had `PDFDocument` and `WordDocument` classes, both inheriting from `Document` and implementing a `render()` method. A developer observes repeated `if-else if` blocks checking the document type before calling `render()`. What is the most appropriate OOP principle to apply to eliminate this conditional logic?
- **Answer:** **C. Polymorphism**
- **Explanation:** Runtime polymorphism (via dynamic method dispatch) allows the calling code to invoke `document.render()` on a base `Document` reference. The JVM automatically executes the overridden method of the actual underlying object, completely removing the need for `instanceof` or `if-else` type inspections.

---

### Question 2
**Scenario:** Which of the following scenarios represent a genuine 'is-a' relationship, making inheritance a suitable design choice? (Select all that apply)
- **Answer:** **A, B, C**
  - **A:** A `Car` is a `Vehicle`. *(Valid is-a relationship)*
  - **B:** A `Rectangle` is a `Shape`. *(Valid is-a relationship)*
  - **C:** A `DatabaseConnection` is a `NetworkResource`. *(Valid is-a relationship)*
  - *(D is invalid: A `HelperUtility` contains a `Calculator` is a "has-a" composition relationship, not "is-a")*

---

### Question 3
**Scenario:** Consider a `Vehicle` base class with a method `startEngine()` and two derived classes, `Car` and `Motorcycle`, both overriding `startEngine()` with their specific engine start sounds. If you have a list of `Vehicle` objects and iterate through this list calling `startEngine()` on each object, what mechanism ensures the correct `startEngine()` implementation is called for each vehicle type?
- **Answer:** **C. Runtime method dispatch**
- **Explanation:** In Java, all non-static, non-final, and non-private method calls are virtual by default. The JVM uses dynamic method dispatch (consulting the vtable of the instantiated runtime object) to invoke the overridden method.

---

### Question 4
**Scenario:** A `Shape` base class has a method `calculateArea()`. `Circle` and `Rectangle` are derived classes, each with their own implementation of `calculateArea()`. If a program stores various `Shape` objects in a list and then calls `calculateArea()` on each, what concept is being demonstrated?
- **Answer:** **C. Inheritance-based polymorphism**

---

### Question 5
**Scenario:** A software component is designed to manage various `LibraryItem` types like `Book` and `DVD`. Both `Book` and `DVD` inherit from `LibraryItem`. The `LibraryItem` class has a `getLoanPeriod()` method. The `Book` class extends this method by adding a special rule for new releases, while the `DVD` class sets a fixed loan period. Which of the following statements accurately describe the behavior in this system? (Select all that apply)
- **Answer:** **A, C, D**
  - **A:** `getLoanPeriod()` in `Book` is an example of extending inherited behavior.
  - **C:** The `LibraryItem` class defines the common behavior for all library items.
  - **D:** A `DVD` object can be processed as a `LibraryItem` through a common reference.

---

### Question 6
**Scenario:** Consider a base class `Animal` with a method `makeSound()` and derived classes `Dog` and `Cat`, which override `makeSound()` to produce 'Woof' and 'Meow' respectively. Which of the following statements about the behavior of these classes are correct? (Select all that apply)
- **Answer:** **A, C**
  - **A:** If a `Dog` object is referred to by an `Animal` reference, calling `makeSound()` will execute `Dog`'s `makeSound()`.
  - **C:** The `makeSound()` method in `Dog` is an example of overridden behavior.

---

### Question 7
**Scenario:** A `PaymentProcessor` system processes `CardPayment` and `BankTransferPayment` objects. Both derive from a `Payment` base class and override `calculateFee()`. If the `PaymentProcessor` maintains a collection of `Payment` references, what is the primary benefit of this design when adding a new `WalletPayment` type?
- **Answer:** **C. It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**
- **Explanation:** This is a direct implementation of the Open-Closed Principle (OCP): the system is open for extension by introducing new derived classes, yet closed for modification because existing processing loops remain untouched.

---

### Question 8
**Scenario:** What is the primary reason why using inheritance solely for superficial code reuse between unrelated classes is generally considered an inappropriate design choice?
- **Answer:** **A. It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**
- **Explanation:** Inheritance is the strongest form of coupling in OOP. Inheriting without a genuine conceptual is-a relationship violates the Liskov Substitution Principle (LSP) and exposes internal implementation details that break future maintainability.

---

### Question 9
**Scenario:** A `Notification` base class has a `send()` method. Derived classes `EmailNotification`, `SMSNotification`, and `PushNotification` each override `send()`. What are the advantages of using inheritance and polymorphism in this notification system design? (Select all that apply)
- **Answer:** **A, C**
  - **A:** It allows a generic `NotificationSender` to send various types of notifications without knowing their concrete types.
  - **C:** It simplifies the process of adding a new notification channel, like `InAppNotification`, without altering existing sender logic.

---

### Question 10
**Scenario:** Which of the following are benefits of using polymorphic collections (e.g., a list of base class references holding derived class objects)? (Select all that apply)
- **Answer:** **A, B, C**
  - **A:** It simplifies iterating over diverse but related objects.
  - **B:** It allows for uniform processing of objects with specialized behavior.
  - **C:** It reduces the need for explicit type casting in common processing loops.

---

## Part 2: Concept Questions & Comprehensive Answers

### Concept 1: Behavior Reuse and Extension in Inheritance
**Question:** Explain how inheritance enables specialized classes to reuse existing behavior from a base class and simultaneously extend or modify that behavior to suit their specific needs. Provide a concrete business example.  
**Answer:**  
Inheritance establishes an IS-A hierarchy where common state (fields) and common logic (concrete methods) reside in the parent class. Derived classes inherit these members automatically, eliminating boilerplate code duplication. When specialized behavior is needed, derived classes can:
1. **Extend:** Call `super.method()` and perform additional domain-specific actions.
2. **Override:** Completely replace the method implementation with custom logic.

*Example:* An e-commerce system has a base class `Order` with `calculateShipping()`. A `PrimeOrder` subclass extends `Order` and overrides `calculateShipping()` to return `0.0` for expedited items, while still reusing the base class `Order.calculateTax()` and order validation logic without modification.

---

### Concept 2: The 'IS-A' Relationship
**Question:** Describe the 'is-a' relationship in OOP. Explain why correctly identifying a genuine 'is-a' relationship is crucial when deciding to use inheritance in a class design.  
**Answer:**  
The 'is-a' relationship asserts that an instance of a subtype can conceptually and functionally substitute for an instance of the supertype everywhere it is used (Liskov Substitution Principle).  
Correctly identifying 'is-a' ensures:
- The derived class actually behaves as a true variant of the base class.
- Calling base class methods on a derived object never results in unexpected errors or unsupported operations.
- Avoids the common anti-pattern of using inheritance for "has-a" (composition) relationships, which tightly couples unrelated concerns.

---

### Concept 3: Method Overriding
**Question:** Define method overriding. Using a realistic business scenario, such as different types of Employee objects calculating their salary differently, illustrate how method overriding allows derived classes to provide their own specific implementations for a method defined in their base class.  
**Answer:**  
Method overriding occurs when a subclass provides a specific implementation of a method that is already declared in its superclass, matching the method's name, parameter list, and compatible return type.  
*Scenario:*
```java
abstract class Employee {
    protected String name;
    protected double baseSalary;
    public abstract double calculatePay();
}

class SalariedEmployee extends Employee {
    public double calculatePay() { return baseSalary; }
}

class CommissionEmployee extends Employee {
    private double sales;
    private double commissionRate;
    public double calculatePay() { return baseSalary + (sales * commissionRate); }
}
```
The payroll system iterates over `List<Employee>` and calls `emp.calculatePay()`, and the JVM dynamically executes the corresponding calculation.

---

### Concept 4: Runtime Polymorphism (Dynamic Dispatch)
**Question:** Explain runtime polymorphism (dynamic dispatch) with common base-type references. How does the system determine which specific implementation to execute?  
**Answer:**  
Runtime polymorphism is the mechanism where a call to an overridden method is resolved at runtime rather than compile-time.  
When the compiler encounters `baseRef.method()`, it verifies that `method()` exists in the declared reference type. At runtime, the JVM inspects the object header of the actual instantiated object to find its class metadata and virtual method table (vtable). It resolves the method pointer corresponding to the concrete runtime class, thereby executing the derived implementation.

---

### Concept 5: Polymorphic Collections
**Question:** Describe how polymorphic collections work. Provide an example and explain the advantages.  
**Answer:**  
A polymorphic collection is a data structure (such as `List<BaseType>`) that stores references of a common supertype or interface, while holding instances of various concrete subclasses.  
*Example:*
```java
List<Vehicle> vehicles = List.of(new Bike(3), new Car(4), new Truck(1));
for (Vehicle v : vehicles) {
    totalRevenue += v.calculateCharge();
}
```
*Advantages:* High cohesion, low coupling, no explicit type-casting, and seamless extensibility when adding new subclasses.

---

### Concept 6: Polymorphism vs Type-Based Conditional Logic
**Question:** Compare and contrast solving problems using polymorphism versus using repeated type-based conditional logic (`if-else` / `switch`). Why is polymorphism preferred?  
**Answer:**  
- **Type-based conditional logic:** Requires inspecting an object's type via `instanceof` or enum codes. Adding a new type requires modifying every single `switch` or `if-else` block across the entire codebase. This violates the Open-Closed Principle and is highly error-prone.
- **Polymorphism:** Decentralizes logic into the classes themselves. Adding a new type only requires creating a new subclass and overriding the target method. Existing client code requires zero modifications.

---

### Concept 7: Open/Closed Principle via Inheritance & Polymorphism
**Question:** Explain how inheritance and polymorphism allow for the addition of new derived types with minimal or no changes to common processing logic (e.g. adding a new `PaymentMethod`).  
**Answer:**  
In a payment processing engine:
```java
public void processPayment(PaymentMethod method, double amount) {
    double finalAmount = method.calculateAdjustedAmount(amount);
    ledger.record(finalAmount);
}
```
If a new payment method `CryptoPayment` is introduced, we simply create:
```java
public class CryptoPayment extends PaymentMethod {
    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount * 1.005; // 0.5% network fee
    }
}
```
`processPayment` does not require a single line change. The architecture is open for extension, yet closed for modification.

---

### Concept 8: Inherited vs Overridden Behavior
**Question:** Distinguish between inherited behavior and overridden behavior. When would a derived class typically inherit vs override?  
**Answer:**  
- **Inherited Behavior:** Code implemented in the base class that subclasses use as-is without modification. Used when the behavior is universal and identical across all subclasses (e.g., `getId()`, `getCreatedAt()`, `turnOn()`).
- **Overridden Behavior:** A method declared in the base class whose implementation is redefined by a subclass. Used when the contract is shared, but the operational mechanics differ by subtype (e.g., `calculateBonus()`, `calculateDueDate()`).

---

### Concept 9: Risks of Superficial Inheritance for Code Reuse
**Question:** Explain why using inheritance solely for code reuse without a genuine 'is-a' relationship is an anti-pattern.  
**Answer:**  
Inheriting solely for utility functions (e.g., making `Customer` extend `ArrayList` or `StringHelper`) leads to:
1. **LSP Violations:** The subclass inherits methods that make no semantic sense in its domain.
2. **Fragile Base Class Problem:** Alterations to the base class can silently break subclass assumptions.
3. **Rigid Architecture:** Java only supports single class inheritance; wasting the single superclass slot on utility reuse prevents genuine domain hierarchies.
4. **Better Alternative:** Favor composition (`has-a`) over inheritance (`is-a`).

---

### Concept 10: Common vs Specialized Behavior in Vehicle Rental
**Question:** Analyze a `VehicleRental` scenario (`CarRental` and `TruckRental`). Identify common vs specialized behaviors and explain how inheritance models this distinction.  
**Answer:**  
- **Common Behaviors (Base Class `Rental`):**
  - Tracking rental duration (`daysRented`), customer ID, rental start date.
  - Common validation: `validateRentalPeriod()`, `issueReceipt()`.
- **Specialized Behaviors (Derived Classes):**
  - `CarRental`: Free mileage allowance, passenger insurance calculation, child-seat surcharges.
  - `TruckRental`: Cargo tonnage tariff, commercial driver log validation, axle weight permit fees.
By placing shared state in `abstract class Rental` and defining `abstract double calculateTotalRentalFee()`, both car and truck rentals can be managed uniformly by the rental management system.

---

## Part 3: Abstraction & Interface Concept Check

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Instance Fields (State)** | Yes (`private`, `protected`, `public`) | No (only `public static final` constants) |
| **Constructors** | Yes (invoked via `super(...)`) | No (interfaces cannot be instantiated) |
| **Method Implementation** | Can mix concrete and abstract methods | Traditionally pure abstract (Java 8+ allows `default`/`static`) |
| **Inheritance Multiplicity** | Single class inheritance (`extends`) | Multiple interface inheritance (`implements`) |
| **Relationship Expressed** | **IS-A** (fundamental identity) | **CAN-DO** (capability / contract) |

---

### Test Yourself Answers

1. **Why does an abstract class have a constructor if it cannot be instantiated directly?**  
   To initialize the state (instance fields) defined in the abstract class. When a concrete subclass is instantiated, its constructor calls `super(...)` to ensure the parent's state is properly initialized.

2. **What compiler error occurs if a subclass fails to implement an abstract method?**  
   `error: SubclassName is not abstract and does not override abstract method methodName() in SuperClassName`. This forces developers to fulfill the promised contract.

3. **Why can `SmartDoorLock` implement `Remoteable` without extending `Device`?**  
   Because `Remoteable` is an interface representing an optional CAN-DO capability, completely independent of the class inheritance hierarchy.

4. **Why does Java allow implementing multiple interfaces but only extending one class?**  
   Extending multiple classes with concrete state and method bodies causes the "Deadly Diamond of Death" ambiguity (conflicting state and multiple inheritance conflicts). Interfaces carry no per-instance state, eliminating state conflict ambiguity.

5. **What happens if you try to reassign an interface field?**  
   Compile-time error: `cannot assign a value to static final variable`. Interface fields are implicitly constants.

6. **What is the practical architectural difference between IS-A and CAN-DO?**  
   IS-A defines an object's permanent, single identity and ancestry. CAN-DO defines supplementary, optional capabilities that can be mixed and matched across unrelated classes.

7. **Is `BasicLamp` any less a `Device` than `SmartLight` if it implements no interfaces?**  
   No. It fully satisfies the IS-A contract of `Device`. Capabilities are optional; identity is complete.

8. **Five related classes share 3 fields and 2 methods, but 1 method behaves differently. Abstract class or interface?**  
   **Abstract Class.** They share state (3 fields) and common code (2 concrete methods) with an IS-A identity. An interface cannot share state or eliminate that duplicated method logic.
