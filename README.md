# VotingService
Assignment 1 for Object-Oriented Programming | CS 3650 Sun | Fall 2020

This voting service program is written in Java and utilizes object-oriented principles.

Description from Assignment
>In this programming assignment, you will build a Java-based simulation tool based the live poll
idea (kahoot or mentimeter) we use during the class. This is going to be a pure desktop based
console program, WITHOUT web interactions or graphical UIs.


Contains:
1. **Student.java** - Student interface
    * gets/sets student ID
    * gets/sets single answer for questions with a single answer
    * gets/sets multiple answers for questions with multiple answers
2. **Question.java** - Question interface
    * gets/sets questions
    * gets/sets answer options (called create & populate)
    * gets/sets correct single answer for questions with a single answer
    * gets/sets correct multiple answers for questions with multiple answers
3. **VotingService.java** - Voting Service interface
    * configures questions, their respective answer options, and their correct answer(s)
    * generates array of student objects, sets their IDs, and sets their answers
    * checks student answers against the correct answers, and returns an array containing the number students who answered correctly
    * prints the student answer results
4. **iVoteStudent.java** - Student class implementing Student.java
5. **iVoteQuestion.java** - Question class implementing Question.java
6. **iVoteVotingService.java** - Voting Service class implementing VotingService.java
7. **SimulationDriver.java** - Creates iVoteVotingService object and runs start() method from iVoteVotingService.java
