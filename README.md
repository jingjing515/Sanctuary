# Primates Sanctuary

## Overview

This project provides a permanent home and high-quality sanctuary care for New World primates who have been cast off from the pet trade, retired from research, or confiscated by authorities. The sanctuary aims to replace all of their paper records with computerized records to keep track of the individual animals in their care. This project implements a full solution using the MVC pattern to satisfy their needs.

## Technical Specifications

### Architecture

- **Model-View-Controller (MVC) Pattern**:
  - The application is designed using the MVC architecture, which divides the application into three interconnected components:
    - **Model**: Responsible for handling data-related logic. It manages the sanctuary's data, including details about the monkeys, their locations, and health statuses.
    - **View**: Manages the presentation layer and user interface. Built using Java Swing, it provides an intuitive and interactive GUI for users to interact with the sanctuary system.
    - **Controller**: Acts as an intermediary between the Model and View, processing user inputs from the View and updating the Model accordingly.

### Technologies

- **Java**: The primary programming language used to develop the application, chosen for its platform independence and robust ecosystem.
- **Java Swing**: Utilized for creating the GUI, offering a rich set of components to design an interactive and responsive user interface.
- **JUnit**: Employed for unit testing to ensure code reliability and correctness, allowing for automated testing of individual components.

### Key Functionalities

- **Registration and Management**:
  - Enables the registration of new monkeys with detailed information, automatically placing them into isolation.
  - Supports moving monkeys between isolation and enclosures based on their health status and space availability.

- **User Notifications**:
  - Provides real-time notifications for invalid inputs, full isolation cages, and health condition changes, ensuring user awareness and data integrity.

- **Data Organization**:
  - Displays lists of monkeys in isolation, enclosures, and an alphabetical list of all monkeys in the sanctuary, making data management straightforward and efficient.

### Build and Deployment

- **Executable JAR File**:
  - The application is packaged as an executable JAR file for easy distribution and deployment. Users can run the program by executing the JAR file on any system with Java installed.

### System Requirements

- **Java Development Kit (JDK) 8 or higher**: Required to compile and run the application, ensuring compatibility with modern Java features.

## List of Features

- **registerMonkey**: Register a new monkey in the sanctuary.
- **moveMonkeyToEnclosure**: Move a monkey from isolation to an enclosure.
- **moveMonkeyToIsolation**: Move a monkey from an enclosure back to isolation.
- **switchEnclosure**: Switch enclosures to show different troops.
- **exitProgram**: Exit the application.

## How to Run & Use the Program

1. **Open the JAR File**: Double-click the JAR file to launch the application.

2. **Register a Monkey**:
   - Use the **north panel** to input the monkey’s information.
   - If the input is invalid, the monkey cannot be registered, and an error message will appear.
   - If there is no room in isolation, registration will be denied with an error message.

3. **Move Monkeys**:
   - Use the **south panel** to move monkeys to either an enclosure or isolation.
   - An error message will appear if the monkey cannot be moved.
   - If a monkey is identified as ill, a confirmation message will prompt the user to update the monkey's health condition. A cured monkey can be moved to the enclosure; otherwise, it cannot be moved.

4. **Check Isolation**:
   - Use the **west panel** to view monkeys in isolation, with each line recording a monkey.

5. **View Enclosures**:
   - Use the **east panel** to view monkeys in enclosures by troop. Selecting a troop will display information about the monkeys in that troop in the right half of the center panel.

6. **View All Monkeys**:
   - The **center panel** displays an alphabetical list of all monkeys in the sanctuary and information about monkeys in the enclosures.

## Limitations

- The current model cannot represent a monkey’s health condition.

## Assumptions

- Every new monkey must be moved into isolation upon arrival.

## Citations

- Dave Kirkwood. (2020, October 30). *Java Swing Components and Containers*. YouTube. Retrieved December 12, 2022, from [https://www.youtube.com/watch?v=1JjTAxbsDqs&t=702s](https://www.youtube.com/watch?v=1JjTAxbsDqs&t=702s)
- YouTube. (2020, September 14). *Java GUI: Full Course ☕ (Free)*. YouTube. Retrieved December 12, 2022, from [https://www.youtube.com/watch?v=Kmgo00avvEw](https://www.youtube.com/watch?v=Kmgo00avvEw)

