# Live Football World Cup Scoreboard

A simple Java library designed to manage and display live football match scores for the World Cup. This project follows **Test-Driven Development (TDD)** and **Clean Code** principles.

## Features

1. **Start a new match**: Initialize matches with a default 0-0 score.
2. **Update score**: Update home and away scores using absolute values, ensuring real-time accuracy.
3. **Finish match**: Efficiently remove completed matches from the active scoreboard.
4. **Get Summary**: Retrieve a live, dynamically sorted summary based on:
    * **Total Score**: Matches with the highest combined score are prioritized first (Descending).
    * **Recency (Tie-breaker)**: If scores are equal, the match that started most recently appears first.

-------------------------------------------------------------------------------

## Technical Explanations

During development, several technical challenges were addressed to ensure the library's quality and reliability:

### 1. Sorting Logic (Tie-breaking)
Matches are ordered by their **Total Score** in descending order.
* **Challenge encountered**: How to handle matches with the same total score?
* **Solution**: When scores are level, the newest match takes the lead. I used the list's natural insertion order as a built-in timer to keep the logic simple and fast.

### 2. Data Integrity & Uniqueness
* **Assumption**: A team can only participate in one active match at a time.
* **Implementation**: The library includes logic to find matches based on team names, ensuring that updates or finishing actions are applied to the correct pair.

### 3. Clean Repository (Environment Isolation)
* **Challenge**: Preventing IDE-specific metadata (like `.idea/` or `.iml` files) from cluttering the repository.
* **Solution**: Configured a robust `.gitignore` file to ensure the codebase remains portable and environment-agnostic.

### 4. Cleaning Code
* **Decision**: During refactoring, unused methods (such as specific internal getters) were removed to adhere to the **YAGNI (You Ain't Gonna Need It)** principle, keeping the API surface clean and focused.

### 5. Problem with (ClassCircularityError)
* **Challenge encountered**: During the initial refactoring of the `Scoreboard` and `Match` classes, a `ClassCircularityError` occurred during the test execution phase.
* **Analysis**: This was identified as a potential conflict in the class-loading hierarchy or a corrupted build cache during the transition between different implementation approaches.
* **Solution**: Resolved by performing a full `mvn clean` and ensuring that the project dependencies and class relationships followed a strict linear hierarchy. This experience highlighted the importance of maintaining a clean build environment and understanding the JVM's class-loading mechanism.

-------------------------------------------------------------------------------

### Requirements
* **Java 17** or higher.
* **Maven** 3.6+.


### ✍️ Author
**Hosam Zaarour**
