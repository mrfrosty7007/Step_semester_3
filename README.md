# Step_semester_3

Repository for **STEP (Student Training in Engineering Program) — Semester 3**  
Course: **B2P15-804 | Classroom 100 Coding Hours Practice**  
Institution: **SRM Institute of Science and Technology**

This branch (`main`) serves exclusively as the central documentation and daily session log for the entire semester.

---

## Date: 26-09-2026

**Today's Work:**
- Created and worked on `feature/session_8` / `week8` / `week_8` for Week 8 — S8 OOP Fundamental (Inheritance, Runtime Polymorphism & Dynamic Method Dispatch).
- Implemented and verified all 5 live-coding class practice problems in package `inheritance.class_problems` (with full interoperability in `polymorphism.class_problems`):
  - `PaymentSystemFeeCalculation`: Abstract `PaymentMethod` base class and concrete subtypes (`CardPayment` 2%, `WalletPayment` 1%, `BankTransferPayment` 0%) with polymorphic transaction processing.
  - `LibraryItemDueDateCalculator`: Abstract `LibraryItem` with specialized borrowing duration (`BookItem` 14 days, `DvdItem` 7 days, `MagazineItem` 3 days) and `LocalDate` calendar math.
  - `DeliveryFeeCalculator`: Hierarchical tariff engine (`StandardDelivery`, `ExpressDelivery`, `InternationalDelivery`) with weight, distance, and encapsulated customs surcharge.
  - `ExaminationQuestionGrader`: Unified examination grading framework (`McqQuestion`, `TrueFalseQuestion`, `EssayQuestion`) supporting exact matching and partial-credit keyword analysis.
  - `PublicTransportFareCalculator`: Polymorphic transport fare calculation (`BusTransport` with cap, `TrainTransport` standard rate, `MetroTransport` with peak-hour multiplier).
- Implemented and verified all 5 homework assignment problems in package `inheritance.assignment_problems` (with full interoperability in `polymorphism.assignment_problems`):
  - `CanteenBillingCounter`: Abstract `Customer` base hierarchy eliminating conditional type-checking (`StudentCustomer` 10% discount, `StaffCustomer` 5% discount, `GuestCustomer` flat service fee).
  - `CampusParkingChargeCalculator`: Dynamic vehicle parking calculation (`Bike` hourly rate, `Car` graduated tariff, `Truck` hourly rate with minimum charge threshold).
  - `HostelElectricityBill`: Encapsulated room model (`SingleRoom`, `SharedRoom` with multi-occupant split, `AcRoom` with fixed overhead surcharge).
  - `FestivalBonusCalculator`: Polymorphic payroll bonus engine (`FullTimeEmployee` 10%, `PartTimeEmployee` 5%, `InternEmployee` fixed ₹2,000 bonus).
  - `StreamingPlanRenewalReminder`: Subscription duration models (`BasicPlan` 30 days, `StandardPlan` 90 days, `PremiumPlan` 365 days) and `LocalDate` renewal computation handling leap years.
- Authored comprehensive reference documentation in `WEEK_8_CONCEPTS_AND_QUIZ.md` with complete answers and architectural rationale for all 10 Quiz Questions, 10 Concept Questions, and 8 Abstraction/Interface Test Questions.
- Tested and compiled all classes against JDK 17 / JDK 21 with 100% test vector match.

**Next Session Plan:**
- Advanced Abstraction, Interfaces, Multiple Interface Inheritance, and Loose Coupling.

**Issues Faced:**
- None

---

## Date: 19-09-2026

**Today's Work:**
- Created and worked on `feature/session_7` / `week7` for Week 7 — S7 OOP Fundamental (Encapsulation & Access Control).
- Implemented and verified all 5 live-coding class practice problems in package `encapsulation.class_problems`:
  - `PiggyBank`: Private savings state, final immutable ID, deposit/withdraw operations with overdraft prevention.
  - `Scorecard`: Encapsulated boolean results array, controlled incremental answer recording, read-only score computation.
  - `NameTag`: Immutable class design, final name components, constructor space-splitting for formatted nickname generation.
  - `Locker`: Write-only security code without getters, authorization validation before PIN code modification.
  - `AttendanceSheet`: Encapsulated student array, automated duplicate prevention, membership lookup, and count inspection.
- Implemented and verified all 5 homework assignment problems in package `encapsulation.assignment_problems`:
  - `Character`: Value clamping logic (0 floor to max cap), private health state, and final maximum health.
  - `Playlist`: Defensive array copying via `Arrays.copyOf` to prevent external collection tampering.
  - `PasswordChecker`: Immutable secret storage without password getters, dynamic strength classification based on length.
  - `TrafficLight`: Controlled circular state transition machine (`RED` -> `GREEN` -> `YELLOW` -> `RED`) with final ID.
  - `Cart`: Encapsulated price array, computed total aggregation on request, and item count tracking.
- Tested and compiled all classes against JDK 21.

**Next Session Plan:**
- Advanced OOP Concepts (Inheritance, Abstract Classes, and Interfaces).

**Issues Faced:**
- None

---

## Date: 12-09-2026

**Today's Work:**
- Created and worked on `feature/session_6` / `week6` for Week 6 — S6 Classes and Objects Revision.
- Implemented and verified all 5 live-coding class problems in package `oop.class_problems`:
  - `PlacementRecord`: Parameterized constructor, object arrays, and structured placement formatting.
  - `MessWallet`: Encapsulation with private balance, validation on opening balance, top-up, and overdraft prevention.
  - `Course`: Constructor overloading and chaining via `this(...)` for theory vs lab courses.
  - `IdCard`: Reference copying vs new object instantiation and identity comparison (`==`).
  - `Student`: Static vs instance fields, shared college name, and static counter tracking total students.
- Implemented and verified all 5 homework assignment problems in package `oop.assignment_problems`:
  - `BookInventory`: Array of objects and formatted inventory entry display.
  - `PayrollAccount`: Private fields, bonus crediting rules, percentage-based tax deduction, read-only net salary.
  - `EmployeeProfileCreation`: Permanent vs intern constructor overloading chaining via `this(...)`.
  - `HallTicket`: Reference aliasing, state modification through alias, and reference equality comparison.
  - `EmployeeCompanyInfoManagement`: Shared company name and static counter tracking total employees.
- Tested and compiled all classes against JDK 21.

**Next Session Plan:**
- Advanced OOP Concepts (Inheritance, Polymorphism, Interfaces, and Abstract Classes).

**Issues Faced:**
- None

---

## Date: 11-09-2026

**Today's Work:**
- Worked on `feature/session_5` / `week4` / `week5` for Category C Assignment Problems (Homework):
  - `FantasyTeamScoreMultiplier`: Direct array mutation with Captain (2.0x) and Vice-Captain (1.5x) multipliers.
  - `DuplicatePlayerPickChecker`: Pairwise nested-loop comparison for repeated player names without Collections.
  - `TopPerformerTracker`: Single-pass running min, max, and spread calculation without sorting.
  - `MatchDayGridAnalyzer`: Modular 2D array analysis with reusable `rowAverage` helper and threshold check.
  - `FantasyLeagueAutoDraftRankingEngine`: Overloaded eligibility rules, encapsulated `Player` model, and `Comparable<Player>` sorting via `Arrays.sort()`.
- Verified test cases, boundary cases, and successful compilation on JDK 21.

**Next Session Plan:**
- Advanced OOP Concepts (Inheritance, Polymorphism, Interfaces, and Abstract Classes).

**Issues Faced:**
- None

---

## Date: 02-09-2026

**Today's Work:**
- Created and worked on `feature/session_4` for Week 4 — S4 Programming Fundamental (Category C).
- Implemented and verified all 5 Category C array algorithms in package `array.class_problems`:
  - `TwoSum`: Nested loop pairwise search for target sum with index validation.
  - `BestTimeToBuyAndSellStock`: Single-pass running minimum and maximum profit calculation.
  - `ContainsDuplicate`: Pairwise comparison with early exit boolean return logic.
  - `MergeTwoSortedArrays`: Two-pointer array traversal and merging without auxiliary sorting.
  - `RotateArray`: Modulo arithmetic indexing and in-place array rotation by k positions.
- Verified test cases, edge cases (empty arrays, boundary limits), and proper exception handling.

**Next Session Plan:**
- Object-Oriented Programming Fundamentals (Classes, Objects, Constructors, and Methods).

**Issues Faced:**
- None

---

## Date: 28-08-2026

**Today's Work:**
- Created and worked on `feature/session_2` for Week 2 — S2 String Operations & Performance.
- Implemented and verified all 5 live-coding class problems in package `string.class_problems`:
  - `VowelConsonantCounter`: Character traversal, case-insensitive comparison, space handling.
  - `CsvStudentRecordParser`: CSV string splitting, 3-field length validation, record formatting.
  - `FileExtensionValidator`: `lastIndexOf('.')` extraction and validation against allowed extensions.
  - `MaskedPhoneNumberFormatter`: 10-digit validation and `XXXXXX-3210` pattern formatting via StringBuilder.
  - `BankTransactionReferenceValidator`: Multi-stage validation, normalization, and structured formatting.
- Implemented and verified all 5 homework assignment problems in package `string.assignment_problems`:
  - `AtmPinLengthValidator`: Single `if/else` exact 4-digit length validation.
  - `WordReversalEncoder`: In-place word reversal using loops and StringBuilder while preserving word order.
  - `ProductInventoryCsvParser`: CSV record extraction and field count validation.
  - `LibraryIsbnValidator`: 13-character ISBN validation and formatted catalog output.
  - `StopWordFilteredFrequencyReport`: Punctuation stripping, stop-word exclusion, frequency counting, descending sort.
- Tested and compiled all classes against JDK 21.

**Next Session Plan:**
- Array fundamentals, memory layouts, and algorithmic array problem solving in Session 4.

**Issues Faced:**
- None

---

## Date: 21-08-2026

**Today's Work:**
- Initialized `Step_semester_3` repository following the STEP branching standard.
- Created `develop` branch for project skeleton.
- Created `feature/session_1` for Week 1 — S1 Java String Concepts.
- Implemented and verified all 5 live-coding class problems in package `string.class_problems`:
  - `RockPaperScissorsGame`: Random move generator, round evaluation, statistics table, and win percentage.
  - `PalindromeChecker`: Implemented 3 independent verification approaches (Iterative, Recursive, and Array Reversal).
  - `BmiCalculator`: Team BMI calculations, health classification, and formatted wellness table.
  - `FirstNonRepeatingCharacter`: Character frequency counting and early-exit scanning.
  - `ReverseCustomerName`: Character array reversal preserving original data integrity.
- Implemented and verified all 5 homework assignment problems in package `string.assignment_problems`:
  - `SeatDuplicationChecker`: Nested loops for duplicate identification without Collections.
  - `TypingSpeedAccuracyChecker`: Positional character matching, accuracy percentage, first mismatch tracking.
  - `TrafficSignalStreakAnalyzer`: Consecutive streak tracking and running maximum detection.
  - `WarehouseInventoryBalancer`: Section quantity summation, balance check, and highest item locator.
  - `MovieReviewWordLengthProfiler`: Review splitting and Short/Medium/Long word length profiling.
- Compiled and verified all test cases with JDK 21.

**Next Session Plan:**
- Week 2 String manipulation methods, StringBuilder performance, and ASCII codes.

**Issues Faced:**
- None

---
