# Number Guessing Game

A console-based interactive number guessing game built to practice core Java programming concepts like encapsulation, constructors, control flow, and more.

## Features Implemented

### UC1: Game Initialization
* Initializes the game environment with a randomized target number (1-100) using a dedicated `GameConfig` class.
* Displays formatted game rules and instructions to the player upon startup.

### UC2: User Guess Submission
* Accepts and processes user input via the console using a game loop.
* Implements a standalone `GuessValidator` class to provide "HIGH", "LOW", or "CORRECT" feedback.
* Tracks attempts and ends the game flow if the user guesses correctly or runs out of tries.

### UC3: Hint Generation
* Adds progressive hints (like even/odd and ranges) using a dedicated `HintService` class.
* Triggers hints automatically after incorrect guesses without revealing the exact number.
* Caps the total number of hints provided to maintain difficulty.

### UC4: Error Handling & Validation
* Introduces a custom `InvalidInputException` to manage errors cleanly.
* Centralizes all input checks in a `ValidationService` to ensure inputs are strictly numeric and within the 1-100 range before processing.

## Tech Stack
* Java

## How to Run
1. Open your terminal or command prompt.
2. Navigate to the project folder.
3. Compile all Java files:
```bash
javac *.java
```

4. Run the application:
```bash
java GuessingApp
```