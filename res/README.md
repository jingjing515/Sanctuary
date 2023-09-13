# README

- **Overview**
    - This project aims to provides a permanent home and high-quality sanctuary care for New World primates who have been cast-off from the pet trade, retired from research, or confiscated by
    authorities. They are seeking to replace all of their paper records with computer records where they can keep track of the individual animals that are in their care. This project aims to build a full solution using the MVC pattern for such a system that can satisfy their needs.
- **List of features**
    - registerMonkey: *register a monkey to sanctuary*
    - moveMonkeyToEnclosure: move a monkey from isolation to enclosure
    - moveMonkeyToIsolation: move a monkey from enclosure  to isolation
    - switchEnclosure: switch enclosure to show different troops
    - exitProgram: exit
- **How To Run &  Use the Program**
    - Open the JRA file
    - Use north panel to register a monkey, input the monkey’s information. If the input is invalid, the monkey cannot be registered and an error message will show up. If there is no room in isolation, the monkey cannot be registered and an error message will show up.
    - Use south panel to move monkey to enclosure or isolation. If the monkey can’t be moved, an error message will show up. If the monkey was identified ill, a confirmation message shows up, the user has to choose the latest health condition of the monkey, if the monkey is cured, it can be moved to the enclosure. Otherwise, the monkey cannot be moved and an error message will show up.
    - Use west panel to check the monkeys in isolation. Each line records a monkey.
    - Use east panel to check the monkeys in enclosure by troop. Choose troop, the right half of center panel will shows the monkeys’ information in the chosen troop
    - the center panel shows the list of all the monkeys in the sanctuary in alphabetical order and the information of monkeys in enclosure.
- **Limitation**
    - cannot represent the monkey’s health condition in this model.
- **Assumptions**
    - Every new monkey has to be moved into isolation
- **Citations**
    - davekirkwood. (2020, October 30). *Java swing components and containers*. YouTube. Retrieved December 12, 2022, from https://www.youtube.com/watch?v=1JjTAxbsDqs&t=702s
    - YouTube. (2020, September 14). *Java GUI: Full course ☕ (free)*. YouTube. Retrieved December 12, 2022, from https://www.youtube.com/watch?v=Kmgo00avvEw